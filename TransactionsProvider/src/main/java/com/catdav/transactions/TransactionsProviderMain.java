package com.catdav.transactions;

import com.catdav.transactions.exceptions.LoginException;
import com.catdav.transactions.login.AuthenticationManager;
import com.catdav.transactions.login.impl.WunderlistAuthenticationManager;

public class TransactionsProviderMain {
  public static void main(String[] args) throws LoginException {
    AuthenticationManager authenticationManager=new WunderlistAuthenticationManager();
    authenticationManager.login();
  }
}
