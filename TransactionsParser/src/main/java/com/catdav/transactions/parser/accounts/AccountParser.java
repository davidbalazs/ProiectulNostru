package com.catdav.transactions.parser.accounts;

import com.catdav.transactions.model.Account;
import com.catdav.transactions.parser.exceptions.AccountParseException;

/**
 * Created by catalina.serbu on 10/14/2016.
 * Class created to parse string to account
 */
public interface AccountParser {
    Account parse(String accountToBeParsed) throws AccountParseException;
}
