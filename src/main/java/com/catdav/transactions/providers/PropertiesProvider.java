package com.catdav.transactions.providers;

import com.catdav.transactions.exceptions.PropertiesRetrievalException;

import java.util.Properties;

/**
 * Created by David on 10/4/2016.
 */
public interface PropertiesProvider {
    Properties getProperties(String location) throws PropertiesRetrievalException;
}
