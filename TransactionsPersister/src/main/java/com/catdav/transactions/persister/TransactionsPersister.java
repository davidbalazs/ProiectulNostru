package com.catdav.transactions.persister;

import com.catdav.transactions.model.TransactionsContainer;

/**
 * Created by David on 10/7/2016.
 */
public interface TransactionsPersister {
    void persist(TransactionsContainer transactionsContainer);
}
