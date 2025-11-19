package org.example.transactions;

import org.example.bankAccounts.BaseBankAccount;

import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {
    private Date date;
    private String uuid;
    private String accountUuid;
    private TransactionTypes transactionType;
    private double amount;

    public Transaction(Date date, String uuid, String accountUuid, TransactionTypes transactionType, double amount) {
        this.date = date;
        this.uuid = uuid;
        this.accountUuid = accountUuid;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public String getUuid() {
        return uuid;
    }

    public String getAccountUuid() {
        return accountUuid;
    }

    public TransactionTypes getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", account=" + accountUuid +
                ", type=" + transactionType +
                ", amount=" + amount +
                '}';
    }
}
