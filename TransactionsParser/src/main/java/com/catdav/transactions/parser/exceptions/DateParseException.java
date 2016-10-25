package com.catdav.transactions.parser.exceptions;

/**
 * Exception that should be thrown whenever the system fails to parse a date.
 *
 * */
public class DateParseException extends TransactionParseException {
    public DateParseException(String message) {
        super(message);
    }

    public DateParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
