package com.catdav.transactions.exceptions;

/**
 * Created by David on 10/11/2016.
 */
public class TransactionsRetrievalException extends TransactionsProviderException {
    public TransactionsRetrievalException(String message) {
        super(message);
    }

    public TransactionsRetrievalException(String message, Throwable cause) {
        super(message, cause);
    }
}
