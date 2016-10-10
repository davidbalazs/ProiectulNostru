package com.catdav.transactions.persister.impl;

import com.catdav.transactions.model.TransactionsContainer;
import com.catdav.transactions.persister.TransactionsPersister;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/7/2016.
 */
public class DefaultTransactionsPersister implements TransactionsPersister {
    @Override
    public void persist(TransactionsContainer transactionsContainer) {
        List<NameValuePair> SpendingsNameValuePairs = new ArrayList<>();
        SpendingsNameValuePairs.add(new BasicNameValuePair("cheltuieliSuma0", "35"));
        SpendingsNameValuePairs.add(new BasicNameValuePair("cheltuieliCont0", "3"));
        SpendingsNameValuePairs.add(new BasicNameValuePair("cheltuieliData0", "2016.10.07"));
        SpendingsNameValuePairs.add(new BasicNameValuePair("cheltuieliCategoria0", "1"));
        SpendingsNameValuePairs.add(new BasicNameValuePair("cheltuieliDescriere0", "tenis"));
        SpendingsNameValuePairs.add(new BasicNameValuePair("cheltuieliAdaugaLaMedie0", "on"));

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPostRequest = new HttpPost("http://localhost/cheltuieli/php/procesare.php");
        httpPostRequest.setEntity(new UrlEncodedFormEntity(SpendingsNameValuePairs, StandardCharsets.UTF_8));
            //todo: what happens if the account with provided id was not found ?
        //todo:: what happens if the xampp is down?
        //todo: what happens if the mysql is down?
        HttpResponse httpResponse;
        try {
             httpResponse = httpClient.execute(httpPostRequest);
        } catch (IOException e) {
            throw new IllegalStateException("add an exception here.");
        }

        try {
            System.out.println(EntityUtils.toString(httpResponse.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
