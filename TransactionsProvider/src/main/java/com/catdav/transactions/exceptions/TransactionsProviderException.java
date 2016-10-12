package com.catdav.transactions.exceptions;

public class TransactionsProviderException extends Exception {
  public TransactionsProviderException(String message) {
    super(message);
  }

  public TransactionsProviderException(String message, Throwable cause) {
    super(message, cause);
  }
}
