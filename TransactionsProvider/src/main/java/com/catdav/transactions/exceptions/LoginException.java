package com.catdav.transactions.exceptions;

public class LoginException extends TransactionsProviderException {

  public LoginException(String message) {
    super(message);
  }

  public LoginException(String message, Throwable cause) {
    super(message, cause);
  }
}
