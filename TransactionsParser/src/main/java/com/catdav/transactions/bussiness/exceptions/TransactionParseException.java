package com.catdav.transactions.bussiness.exceptions;

import com.catdav.transactions.exceptions.GeneralException;

/**
 * Exception that should be extended by any exception thrown in main module.
 */

public class TransactionParseException extends Exception {
    public TransactionParseException(String message) { super(message);  }

    public TransactionParseException(String message, Throwable cause) {  super(message, cause);   }
}
