package com.catdav.transactions.exceptions;

/**
 * Exception that should be extended by any exception thrown in TransactionsPersister module.
 *
 * Created by David on 10/4/2016.
 */
public class TransactionPersisterException extends Exception {
    public TransactionPersisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransactionPersisterException(String message) {
        super(message);
    }
}
