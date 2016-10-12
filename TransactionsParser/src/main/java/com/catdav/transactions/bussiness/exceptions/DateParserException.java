package com.catdav.transactions.bussiness.exceptions;

public class DateParserException extends TransactionParseException {
    public DateParserException(String message) {
        super(message);
    }

    public DateParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
