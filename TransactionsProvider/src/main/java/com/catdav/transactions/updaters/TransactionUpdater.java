package com.catdav.transactions.updaters;

import com.catdav.transactions.exceptions.TransactionUpdateException;

/**
 * Created by David on 10/11/2016.
 */
public interface TransactionUpdater {
    void markAsComplete(String transactionId, int revisionNumber) throws TransactionUpdateException;
}
