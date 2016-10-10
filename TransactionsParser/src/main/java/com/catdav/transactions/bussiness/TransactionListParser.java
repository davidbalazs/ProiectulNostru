package com.catdav.transactions.bussiness;

import com.catdav.transactions.model.TransactionsContainer;

import java.util.List;

public interface TransactionListParser {

    TransactionsContainer parse(List<String> transactionsToBeParsed);
}
