package com.catdav.transactions.providers.impl;

import com.catdav.transactions.exceptions.PropertiesRetrievalException;
import com.catdav.transactions.exceptions.TransactionsRetrievalException;
import com.catdav.transactions.model.UnparsedTransaction;
import com.catdav.transactions.providers.PropertiesProvider;
import com.catdav.transactions.providers.TransactionsProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by David on 10/11/2016.
 */
public class WunderlistTransactionsProvider implements TransactionsProvider {
    private static final Logger LOG = Logger.getLogger(WunderlistTransactionsProvider.class);
    public static final String PROPERTIES_FILE_LOCATION = "wunderlist.properties";
    private PropertiesProvider propertiesProvider;

    public WunderlistTransactionsProvider() {
        propertiesProvider = new FilePropertiesProvider();
    }

    @Override
    public List<UnparsedTransaction> getTransactions() throws TransactionsRetrievalException {
        Properties properties = getProperties();
        URI transactionsUri = getTransactionsFullUrl(properties);
        String accessToken = getAccessToken(properties);
        String clientId = getClientId(properties);
        HttpResponse httpResponse = sendRequest(transactionsUri, accessToken, clientId);
        String transactionsJsonString = getJsonString(httpResponse);

        Gson gson = new GsonBuilder().create();
        UnparsedTransaction[] unparsedTransactions = gson.fromJson(transactionsJsonString, UnparsedTransaction[].class);

        return Arrays.asList(unparsedTransactions);
    }

    private HttpResponse sendRequest(URI transactionsUri, String accessToken, String clientId) throws TransactionsRetrievalException {
        LOG.info("Sending get transactions request to url:" + transactionsUri);
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpRequest = new HttpGet(transactionsUri);
        httpRequest.addHeader("X-Client-ID", clientId);
        httpRequest.addHeader("X-Access-Token", accessToken);
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpRequest);
            int responseStatusCode = httpResponse.getStatusLine().getStatusCode();
            if (responseStatusCode != HttpStatus.SC_OK) {
                throw new TransactionsRetrievalException("request ended with response status code different from 200. " +
                        "The actual status code is. Check if access token is still valid." + responseStatusCode);
            }

            return httpResponse;
        } catch (IOException e) {
            throw new TransactionsRetrievalException("Cannot send request to url:" + transactionsUri, e);
        }
    }

    private URI getTransactionsFullUrl(Properties properties) throws TransactionsRetrievalException {
        String baseUrl = getTransactionsUrl(properties);

        URIBuilder builder = new URIBuilder();
        builder.setScheme("https").setHost(baseUrl)
                .setParameter("list_id", getTransactionsListId(properties));
        try {
            return builder.build();
        } catch (URISyntaxException e) {
            throw new TransactionsRetrievalException("Cannot build authorization URI.", e);
        }
    }

    private String getTransactionsListId(Properties properties) {
        return properties.getProperty("wunderlist.transactions.list.id");
    }

    private String getTransactionsUrl(Properties properties) {
        return properties.getProperty("wunderlist.tasks.url");
    }

    private String getClientId(Properties properties) {
        return properties.getProperty("wunderlist.client.id");
    }

    private String getAccessToken(Properties properties) {
        return properties.getProperty("wunderlist.access.token");
    }

    private Properties getProperties() throws TransactionsRetrievalException {
        try {
            return propertiesProvider.getProperties(PROPERTIES_FILE_LOCATION);
        } catch (PropertiesRetrievalException e) {
            throw new TransactionsRetrievalException("Transactions retrieval failed, because an error occured while reading properties.", e);
        }
    }

    private String getJsonString(HttpResponse httpResponse) throws TransactionsRetrievalException {
        try {
            return EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        } catch (IOException e) {
            throw new TransactionsRetrievalException("Cannot get json string from httpResponse.", e);
        }
    }
}
