package com.catdav.transactions.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/7/2016.
 */
public class TransactionsContainer {
    private List<Spending> spendings;
    private List<AccountOperation> accountOperations;
    private List<Transfer> transfers;

    public TransactionsContainer() {
        spendings = new ArrayList<>();
        accountOperations = new ArrayList<>();
        transfers = new ArrayList<>();
    }

    void addSpending(Spending spending) {
        spendings.add(spending);
    }

    void addAccountOperation(AccountOperation accountOperation) {
        accountOperations.add(accountOperation);
    }

    void addTransfer(Transfer transfer) {
        transfers.add(transfer);
    }

    public List<Spending> getSpendings() {
        return spendings;
    }

    public List<AccountOperation> getAccountOperations() {
        return accountOperations;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }
}
