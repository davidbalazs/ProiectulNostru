package com.catdav.transactions.model;

import java.util.Date;

public class Transaction {

    private int revisionNumber;
    private String id;
    private int value;
    private Account sourceAccount;
    private String description;
    private Date date;

    public Transaction(int revisionNumber, String id, int value, Account sourceAccount, String description, Date date) {
        this.revisionNumber = revisionNumber;
        this.id = id;
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

    public int getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(int revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
