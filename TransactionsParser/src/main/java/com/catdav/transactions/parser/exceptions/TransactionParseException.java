package com.catdav.transactions.parser.exceptions;

/**
 *  Exception that should be thrown whenever the system fails to parse a transaction.
 */

public class TransactionParseException extends Exception {
    public TransactionParseException(String message) { super(message);  }

    public TransactionParseException(String message, Throwable cause) {  super(message, cause);   }
}
