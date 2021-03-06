package com.catdav.transactions.model;

import java.util.Date;

public class AccountOperation extends Transaction {

    private AccountOperationType type;

    public AccountOperation(int revisionNumber, String id, int value, Account sourceAccount, String description, Date date, AccountOperationType type) {
        super(revisionNumber, id, value, sourceAccount, description, date);
        this.type = type;
    }

    public AccountOperationType getType() {
        return type;
    }

    public void setType(AccountOperationType type) {
        this.type = type;
    }
}
