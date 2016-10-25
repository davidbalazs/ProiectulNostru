package com.catdav.transactions.parser.main;

import com.catdav.transactions.model.TransactionsContainer;

import java.util.List;

/**
 * parse a list of strings into a container that helds the three lists of transactions: spendings, accountOperation and transfers
 */
public interface TransactionListParser {

    TransactionsContainer parse(List<String> transactionsToBeParsed);
}
