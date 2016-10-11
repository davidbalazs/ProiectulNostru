package com.catdav.transactions.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by David on 10/11/2016.
 */
public class UnparsedTransaction {
    private String id;

    @SerializedName("title")
    private String value;

    @SerializedName("revision")
    private Integer revisionNumber;

    public UnparsedTransaction() {
    }

    public UnparsedTransaction(String id, String value, Integer revisionNumber) {
        this.id = id;
        this.value = value;
        this.revisionNumber = revisionNumber;
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

    public Integer getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(Integer revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    @Override
    public String toString() {
        return "UnparsedTransaction{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", revisionNumber=" + revisionNumber +
                "}\n";
    }
}
