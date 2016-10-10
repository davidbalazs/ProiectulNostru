package com.catdav.transactions.exceptions;

/**
 * Created by David on 10/4/2016.
 */
public class PropertiesRetrievalException extends GeneralException {
    public PropertiesRetrievalException(String message) {
        super(message);
    }

    public PropertiesRetrievalException(String message, Throwable cause) {
        super(message, cause);
    }
}
