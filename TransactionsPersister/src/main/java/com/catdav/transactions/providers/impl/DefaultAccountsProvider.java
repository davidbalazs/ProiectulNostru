package com.catdav.transactions.providers.impl;

import com.catdav.transactions.model.Account;
import com.catdav.transactions.providers.AccountsProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.catdav.transactions.exceptions.AccountsRetrievalException;
import com.catdav.transactions.exceptions.PropertiesRetrievalException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.catdav.transactions.providers.PropertiesProvider;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Created by David on 10/4/2016.
 */
public class DefaultAccountsProvider implements AccountsProvider {
    public static final String PROPERTIES_FILE_LOCATION = "php-app.properties";
    private PropertiesProvider propertiesProvider;

    public DefaultAccountsProvider() {
        propertiesProvider = new FilePropertiesProvider();
    }

    public List<Account> getAccounts() throws AccountsRetrievalException {
        String accountsFullUrl = getAccountsFullUrl();
        HttpResponse httpResponse = sendRequest(accountsFullUrl);
        String jsonString = getJsonString(httpResponse);

        Gson gson = new GsonBuilder().create();
        Account[] accounts = gson.fromJson(jsonString, Account[].class);

        return Arrays.asList(accounts);
    }

    private String getAccountsFullUrl() throws AccountsRetrievalException {
        Properties properties;
        try {
            properties = propertiesProvider.getProperties(PROPERTIES_FILE_LOCATION);
        } catch (PropertiesRetrievalException e) {
            throw new AccountsRetrievalException("Cannot retrieve properties from file with name: " + PROPERTIES_FILE_LOCATION, e);
        }
        String baseUrl = properties.getProperty("php.app.baseurl");
        String getAccountsUrl = properties.getProperty("php.app.accountsurl");
        return baseUrl + getAccountsUrl;
    }

    private HttpResponse sendRequest(String accountsFullUrl) throws AccountsRetrievalException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpRequest = new HttpGet(accountsFullUrl);
        try {
            HttpResponse httpResponse = httpClient.execute(httpRequest);
            int responseStatusCode = httpResponse.getStatusLine().getStatusCode();
            if (responseStatusCode != HttpStatus.SC_OK) {
                throw new AccountsRetrievalException("Request sent to " + accountsFullUrl + " gave status code " + responseStatusCode);
            }

            return httpResponse;
        } catch (IOException e) {
            throw new AccountsRetrievalException("Cannot send request to url:" + accountsFullUrl, e);
        }
    }

    private String getJsonString(HttpResponse httpResponse) throws AccountsRetrievalException {
        try {
            return EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        } catch (IOException e) {
            throw new AccountsRetrievalException("Cannot get json string from httpResponse.", e);
        }
    }
}
