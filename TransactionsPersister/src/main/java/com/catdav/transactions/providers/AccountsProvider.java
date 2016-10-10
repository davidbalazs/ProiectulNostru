package com.catdav.transactions.providers;

import com.catdav.transactions.model.Account;
import com.catdav.transactions.exceptions.AccountsRetrievalException;

import java.util.List;

/**
 * Created by David on 10/4/2016.
 */
public interface AccountsProvider {
    List<Account> getAccounts() throws AccountsRetrievalException;
}
