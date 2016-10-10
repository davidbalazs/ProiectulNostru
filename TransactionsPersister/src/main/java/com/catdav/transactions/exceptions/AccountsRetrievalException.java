package com.catdav.transactions.exceptions;

/**
 * Exception to be thrown when the system fails to retrieve accounts.
 * Created by David on 10/4/2016.
 */
public class AccountsRetrievalException extends TransactionPersisterException {
    public AccountsRetrievalException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountsRetrievalException(String message) {
        super(message);
    }
}
