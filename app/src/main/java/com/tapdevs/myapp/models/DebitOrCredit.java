package com.tapdevs.myapp.models;

/**
 * Created by  Jan Shair on 30/01/2017.
 */

public class DebitOrCredit {

    private String description="No Description";
    private double amount;

    public DebitOrCredit() {
    }

    public DebitOrCredit(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
