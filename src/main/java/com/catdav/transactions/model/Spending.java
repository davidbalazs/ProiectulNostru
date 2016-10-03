package com.catdav.transactions.model;


import java.util.Date;

public class Spending extends Transaction{

    private SpendingCategory category;
    private boolean addToAverage;

    public Spending(int value, Account sourceAccount, String description, Date date, SpendingCategory category, boolean addToAverage) {
        super(value, sourceAccount, description, date);
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
