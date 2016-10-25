package com.catdav.transactions.parser.accounts;

import com.catdav.transactions.model.Account;
import com.catdav.transactions.providers.AccountsProvider;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * dummy accounts provider-> use DefaultAccountsProvider when logged in LAN with php app
 */
public class DevelopmentAcountsProvider implements AccountsProvider {

    private static final Logger LOG = Logger.getLogger(DevelopmentAcountsProvider.class);

    public List<Account> getAccounts(){

        LOG.error("this is a test implementation. use the real one when available");
        ArrayList accountsList = new ArrayList<Account>();
        accountsList.add(new Account(1,"ing"));
        accountsList.add(new Account(2,"ingcat"));
        accountsList.add(new Account(3,"bcr"));
        accountsList.add(new Account(4,"ecocat"));
        accountsList.add(new Account(4,"ecodav"));
        accountsList.add(new Account(6,"bonuri"));

        return accountsList;
    }
}
