package com.ibm.pnc.models;

import java.sql.Timestamp;

public class TransactionsDto {

    private String accountNumber;
    private Timestamp transactionTs;
    private String type;
    private double amount;


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Timestamp getTransactionTs() {
        return transactionTs;
    }

    public void setTransactionTs(Timestamp transactionTs) {
        this.transactionTs = transactionTs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
