package com.catdav.transactions.model;


import java.util.Date;

public class Spending extends Transaction{

    SpendingCategory category;
    boolean addToAverage;

    public Spending(int value, Date date, String description, Account sourceAccount, SpendingCategory category, boolean addToAverage) {
        super(value, date, description, sourceAccount);
        this.category = category;
        this.addToAverage = addToAverage;
    }

    public SpendingCategory getCategory() {
        return category;
    }

    public void setCategory(SpendingCategory category) {
        this.category = category;
    }

    public boolean isAddToAverage() {
        return addToAverage;
    }

    public void setAddToAverage(boolean addToAverage) {
        this.addToAverage = addToAverage;
    }
}
