package com.catdav.transactions.parser.accounts.impl;

import com.catdav.transactions.model.Account;
import com.catdav.transactions.parser.accounts.AccountParser;
import com.catdav.transactions.parser.accounts.DevelopmentAcountsProvider;
import com.catdav.transactions.parser.exceptions.AccountParseException;
import com.catdav.transactions.providers.AccountsProvider;

import java.util.List;

public class DefaultAccountParser implements AccountParser {

    public Account Parse(String accountToBeParsed) throws AccountParseException{

        Account parsedAccount = null;
        AccountsProvider accountProvider = new DevelopmentAcountsProvider();
        List<Account> accountsList = accountProvider.getAccounts();

        for(Account a:accountsList){
            if(a.getName().equals(accountToBeParsed)){
                parsedAccount = a;
            }
        }
        if(parsedAccount == null){
            throw new AccountParseException("Cannot find account with name."+accountToBeParsed+"possible values are: "+accountsList);
        }

        return parsedAccount;
    }

}
