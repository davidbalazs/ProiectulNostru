package com.catdav.transactions.model;


import java.util.Date;

public class Transfer extends Transaction {

    Account destinationAccount;

    public Transfer(int value, Date date, String description, Account sourceAccount, Account destinationAccount) {
        super(value, date, description, sourceAccount);
        this.destinationAccount = destinationAccount;
    }
}
