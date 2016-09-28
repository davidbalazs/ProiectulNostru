package com.catdav.transactions.model;

import java.util.Date;

public class Transaction {

    int value;
    Date date;
    String description;
    Account sourceAccount;

    public Transaction(int value, Date date, String description, Account sourceAccount) {
        this.value = value;
        this.date = date;
        this.description = description;
        this.sourceAccount = sourceAccount;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }
}
