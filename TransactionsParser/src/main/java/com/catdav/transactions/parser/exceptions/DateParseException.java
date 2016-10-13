package com.catdav.transactions.parser.exceptions;

public class DateParseException extends TransactionParseException {
    public DateParseException(String message) {
        super(message);
    }

    public DateParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
