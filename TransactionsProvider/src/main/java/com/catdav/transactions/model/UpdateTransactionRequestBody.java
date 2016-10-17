package com.catdav.transactions.model;

/**
 * Created by David on 10/11/2016.
 */
public class UpdateTransactionRequestBody {
    private int revision;
    private boolean completed;

    public UpdateTransactionRequestBody() {
    }

    public UpdateTransactionRequestBody(int revision, boolean completed) {
        this.revision = revision;
        this.completed = completed;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
