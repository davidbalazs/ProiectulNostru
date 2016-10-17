package com.catdav.transactions.updaters.impl;

import com.catdav.transactions.exceptions.PropertiesRetrievalException;
import com.catdav.transactions.exceptions.TransactionUpdateException;
import com.catdav.transactions.model.UnparsedTransactionAfterUpdate;
import com.catdav.transactions.model.UpdateTransactionRequestBody;
import com.catdav.transactions.providers.PropertiesProvider;
import com.catdav.transactions.providers.impl.FilePropertiesProvider;
import com.catdav.transactions.updaters.TransactionUpdater;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by David on 10/11/2016.
 */
public class WunderlistTransactionUpdater implements TransactionUpdater {
    private static final Logger LOG = Logger.getLogger(WunderlistTransactionUpdater.class);
    public static final String PROPERTIES_FILE_LOCATION = "wunderlist.properties";
    private PropertiesProvider propertiesProvider;

    public WunderlistTransactionUpdater() {
        propertiesProvider = new FilePropertiesProvider();
    }

    @Override
    public void markAsComplete(String transactionId, int revisionNumber) throws TransactionUpdateException {
        LOG.info("Marking transaction with [id=" + transactionId + " , revisionNumber=" + revisionNumber + "] as complete");
        Properties properties = getProperties();
        String updateTransactionUrl = getUpdateTransactionUrl(properties, transactionId);
        String accessToken = getAccessToken(properties);
        String clientId = getClientId(properties);
        HttpResponse httpResponse = sendRequest(updateTransactionUrl, accessToken, clientId, revisionNumber);

        String responseBody = getResponseBody(httpResponse);
        Gson gson = new GsonBuilder().create();
        UnparsedTransactionAfterUpdate unparsedUpdatedTransaction = gson.fromJson(responseBody, UnparsedTransactionAfterUpdate.class);

        if (!isTransactionMarkedAsComplete(unparsedUpdatedTransaction)) {
            throw new TransactionUpdateException("Transaction was not marked as complete: " + unparsedUpdatedTransaction);
        }

        LOG.info("Transaction transaction with [id=" + transactionId + " , revisionNumber=" + revisionNumber + "] was marked as complete.");
    }

    private boolean isTransactionMarkedAsComplete(UnparsedTransactionAfterUpdate unparsedUpdatedTransaction) {
        return Boolean.TRUE.equals(unparsedUpdatedTransaction.isCompleted());
    }

    private HttpResponse sendRequest(String updateTransactionUrl, String accessToken, String clientId, int transactionRevisionNumber) throws TransactionUpdateException {
        LOG.info("Sending update transaction request to url: " + updateTransactionUrl);
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPatch httpRequest = new HttpPatch(updateTransactionUrl);
        httpRequest.addHeader("X-Client-ID", clientId);
        httpRequest.addHeader("X-Access-Token", accessToken);
        httpRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        try {
            httpRequest.setEntity(new ByteArrayEntity(createRequestBody(transactionRevisionNumber).getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new TransactionUpdateException("Cannot create request body.", e);
        }
//todo: add request body here:
        // {
        //   "revision":1,
        //   "completed":true
        // }

        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpRequest);
            int responseStatusCode = httpResponse.getStatusLine().getStatusCode();
            if (responseStatusCode != HttpStatus.SC_OK) {
                if (responseStatusCode == HttpStatus.SC_CONFLICT) {
                    throw new TransactionUpdateException("request ended with response status code different from 200. " +
                            "The actual status code is: " + responseStatusCode + ". This is because the transaction's revisionNumber does not " +
                            "correspond to the newest one on your support (e.g. wunderlist).");
                }

                throw new TransactionUpdateException("request ended with response status code different from 200. " +
                        "The actual status code is: " + responseStatusCode + ". Check if access token is still valid." +
                        "response body is: " + getResponseBody(httpResponse));
            }

            return httpResponse;
        } catch (IOException e) {
            throw new TransactionUpdateException("Cannot send request to url:" + updateTransactionUrl, e);
        }

    }

    private String createRequestBody(int revision) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(new UpdateTransactionRequestBody(1, true));
    }

    private String getUpdateTransactionUrl(Properties properties, String transactionId) {
        String baseUrl = properties.getProperty("wunderlist.transaction.update.url");
        return baseUrl + transactionId;
    }

    private String getClientId(Properties properties) {
        return properties.getProperty("wunderlist.client.id");
    }

    private String getAccessToken(Properties properties) {
        return properties.getProperty("wunderlist.access.token");
    }

    private Properties getProperties() throws TransactionUpdateException {
        try {
            return propertiesProvider.getProperties(PROPERTIES_FILE_LOCATION);
        } catch (PropertiesRetrievalException e) {
            throw new TransactionUpdateException("Transaction update failed, because an error occured while reading properties.", e);
        }
    }

    private String getResponseBody(HttpResponse httpResponse) throws TransactionUpdateException {
        try {
            return EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        } catch (IOException e) {
            throw new TransactionUpdateException("Cannot get response body string from httpResponse.", e);
        }
    }
}
