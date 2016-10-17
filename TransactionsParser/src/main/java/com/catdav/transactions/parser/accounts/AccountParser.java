package com.catdav.transactions.parser.accounts;

import com.catdav.transactions.model.Account;
import com.catdav.transactions.parser.exceptions.AccountParseException;

/**
 * Created by catalina.serbu on 10/14/2016.
 */
public interface AccountParser {
    Account parse(String accountToBeParsed) throws AccountParseException;
}
