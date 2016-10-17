package com.catdav.transactions.parser.main;

import com.catdav.transactions.model.TransactionsContainer;

import java.util.List;

public interface TransactionListParser {

    TransactionsContainer parse(List<String> transactionsToBeParsed);
}
