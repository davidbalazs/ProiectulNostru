package com.catdav.transactions;

import com.catdav.transactions.exceptions.TransactionsRetrievalException;
import com.catdav.transactions.providers.TransactionsProvider;
import com.catdav.transactions.providers.impl.WunderlistTransactionsProvider;

public class TransactionsProviderMain {
    public static void main(String[] args) throws TransactionsRetrievalException {
        TransactionsProvider transactionsProvider = new WunderlistTransactionsProvider();
        System.out.println(transactionsProvider.getTransactions());
    }
}
