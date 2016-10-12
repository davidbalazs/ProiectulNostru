package com.catdav.transactions;

import com.catdav.transactions.exceptions.TransactionUpdateException;
import com.catdav.transactions.exceptions.TransactionsRetrievalException;
import com.catdav.transactions.providers.TransactionsProvider;
import com.catdav.transactions.providers.impl.WunderlistTransactionsProvider;
import com.catdav.transactions.updaters.TransactionUpdater;
import com.catdav.transactions.updaters.impl.WunderlistTransactionUpdater;

public class TransactionsProviderMain {
    public static void main(String[] args) throws TransactionsRetrievalException, TransactionUpdateException {
//        TransactionsProvider transactionsProvider = new WunderlistTransactionsProvider();
//        System.out.println(transactionsProvider.getTransactions());

        TransactionUpdater transactionUpdater=new WunderlistTransactionUpdater();
        transactionUpdater.markAsComplete("1396530118",1);
    }
}
