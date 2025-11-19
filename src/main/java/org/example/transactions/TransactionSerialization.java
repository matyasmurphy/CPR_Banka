package org.example.transactions;

import org.example.bankAccounts.BaseBankAccount;

import java.util.Date;

public class TransactionSerialization {
    public Date date;
    public String uuid;
    public String accountUuid;
    public TransactionTypes transactionType;
    public double amount;
}
