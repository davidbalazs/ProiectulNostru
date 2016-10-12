package com.catdav.transactions.bussiness.exceptions;

/**
 * Created by catalina.serbu on 10/12/2016.
 */
public class AccountParseException extends TransactionParseException {
    public AccountParseException(String message) {
        super(message);
    }

    public AccountParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
