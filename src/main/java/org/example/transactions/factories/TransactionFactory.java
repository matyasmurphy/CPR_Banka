package org.example.transactions.factories;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.bankAccounts.BaseBankAccount;
import org.example.transactions.Transaction;
import org.example.transactions.generators.TransactionUuidGen;
import org.example.transactions.manager.TransactionManager;
import org.example.transactions.TransactionTypes;

import java.util.Date;

@Singleton
public class TransactionFactory {

    @Inject
    private TransactionManager transactionManager;

    @Inject
    private TransactionUuidGen transactionUuidGen;

    public Transaction createTransaction(Date date, String accountUuid, TransactionTypes transactionType, double amount) {
        String transactionUuid = transactionUuidGen.generateTransactionUuid();
        Transaction newTransaction = new Transaction(date, transactionUuid, accountUuid, transactionType, amount);

        transactionManager.addTransaction(newTransaction);
        return newTransaction;
    }
}
