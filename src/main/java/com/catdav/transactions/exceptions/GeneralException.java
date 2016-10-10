package com.catdav.transactions.exceptions;

/**
 * Exception that should be extended by any exception thrown in main module.
 * Created by David on 10/4/2016.
 */
public class GeneralException extends Exception {
    public GeneralException(String message) {
        super(message);
    }

    public GeneralException(String message, Throwable cause) {
        super(message, cause);
    }
}
