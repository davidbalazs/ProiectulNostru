package com.catdav.transactions.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by David on 10/11/2016.
 */
public class UnparsedTransactionAfterUpdate extends UnparsedTransaction {
    @SerializedName("completed")
    private Boolean isCompleted;

    public UnparsedTransactionAfterUpdate() {
        super();
    }

    public UnparsedTransactionAfterUpdate(String id, String value, Integer revisionNumber, Boolean isCompleted) {
        super(id, value, revisionNumber);
        this.isCompleted = isCompleted;
    }

    public Boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return super.toString()+"{" +
                "isCompleted=" + isCompleted +
                '}';
    }
}
