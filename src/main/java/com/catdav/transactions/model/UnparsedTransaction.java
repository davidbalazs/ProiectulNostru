package com.catdav.transactions.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by David on 10/11/2016.
 */
public class UnparsedTransaction {
    private String id;

    @SerializedName("title")
    private String value;

    public UnparsedTransaction() {
    }

    public UnparsedTransaction(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                "}\n";
    }
}
