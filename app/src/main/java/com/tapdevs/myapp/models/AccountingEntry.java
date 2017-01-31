package com.tapdevs.myapp.models;

import java.util.Date;

import javax.inject.Inject;

/**
 * Created by  Jan Shair on 30/01/2017.
 */

public class AccountingEntry {

    private DebitOrCredit debitOrCredit;
    private Date date;

    @Inject
    public AccountingEntry(DebitOrCredit debitOrCredit) {
        this.debitOrCredit = debitOrCredit;
    }

    public AccountingEntry(DebitOrCredit debitOrCredit, Date date) {
        this.debitOrCredit = debitOrCredit;
        this.date = date;
    }

    public AccountingEntry() {
    }

    public DebitOrCredit getDebitOrCredit() {
        return debitOrCredit;
    }

    public void setDebitOrCredit(DebitOrCredit debitOrCredit) {
        this.debitOrCredit = debitOrCredit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
