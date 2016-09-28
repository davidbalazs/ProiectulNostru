package com.catdav.transactions.model;

import java.util.Date;

public class AccountOperation extends Transaction {

    AccountOperationType type;

    public AccountOperation(int value, Date date, String description, Account sourceAccount, AccountOperationType type) {
        super(value, date, description, sourceAccount);
        this.type = type;
    }

    public AccountOperationType getType() {
        return type;
    }

    public void setType(AccountOperationType type) {
        this.type = type;
    }
}
