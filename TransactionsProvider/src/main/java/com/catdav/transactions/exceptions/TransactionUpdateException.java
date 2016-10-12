package com.catdav.transactions.exceptions;

/**
 * Created by David on 10/11/2016.
 */
public class TransactionUpdateException extends TransactionsProviderException {
    public TransactionUpdateException(String message) {
        super(message);
    }

    public TransactionUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
