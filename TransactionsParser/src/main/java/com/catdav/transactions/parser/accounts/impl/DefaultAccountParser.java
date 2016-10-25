package com.catdav.transactions.parser.accounts.impl;

import com.catdav.transactions.exceptions.AccountsRetrievalException;
import com.catdav.transactions.model.Account;
import com.catdav.transactions.parser.accounts.AccountParser;
import com.catdav.transactions.parser.accounts.DevelopmentAcountsProvider;
import com.catdav.transactions.parser.exceptions.AccountParseException;
import com.catdav.transactions.providers.AccountsProvider;

import java.util.ArrayList;
import java.util.List;

public class DefaultAccountParser implements AccountParser {

    public Account parse(String accountToBeParsed) throws AccountParseException{

        List<Account> accountsList = new ArrayList<>();

        AccountsProvider accountProvider = new DevelopmentAcountsProvider();
        try {
            accountsList = accountProvider.getAccounts();
        }catch(AccountsRetrievalException are){
            throw new AccountParseException("NULL accountsList");

        }
        Account parsedAccount = null;

        for(Account a:accountsList){
            if(a.getName().equals(accountToBeParsed)){
                parsedAccount = a;
                break;
            }
        }
        if(parsedAccount == null){
            throw new AccountParseException("Cannot find account with name."+accountToBeParsed+", possible values are: "+accountsList);
        }

        return parsedAccount;
    }

}
