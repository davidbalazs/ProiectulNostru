package com.catdav.transactions.model;


import java.util.Date;

public class Transfer extends Transaction {

    private Account destinationAccount;

    public Transfer(int revisionNumber, String id, int value, Account sourceAccount, String description, Date date, Account destinationAccount) {
        super(revisionNumber, id, value, sourceAccount, description, date);
        this.destinationAccount = destinationAccount;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
}
