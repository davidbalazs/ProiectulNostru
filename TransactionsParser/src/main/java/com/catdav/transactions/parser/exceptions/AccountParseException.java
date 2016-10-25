package com.catdav.transactions.parser.exceptions;

/**
 * Created by catalina.serbu on 10/12/2016.
 * Exception that should be thrown whenever the system fails to parse an account.
 */
public class AccountParseException extends TransactionParseException {
    public AccountParseException(String message) {
        super(message);
    }

    public AccountParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
