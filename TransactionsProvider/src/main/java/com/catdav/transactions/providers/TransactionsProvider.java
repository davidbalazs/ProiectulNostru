package com.catdav.transactions.providers;

import com.catdav.transactions.exceptions.TransactionsRetrievalException;
import com.catdav.transactions.model.UnparsedTransaction;

import java.util.List;

public interface TransactionsProvider {
    List<UnparsedTransaction> getTransactions() throws TransactionsRetrievalException;
}
