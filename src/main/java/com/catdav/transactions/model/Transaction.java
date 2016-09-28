package com.catdav.transactions.model;

import java.util.Date;

public class Transaction {

    private int value;
    private Account sourceAccount;
    private String description;
    private Date date;

    public Transaction(int value, Account sourceAccount, String description, Date date) {
        this.value = value;
        this.sourceAccount = sourceAccount;
        this.description = description;
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
