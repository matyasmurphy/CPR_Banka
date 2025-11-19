package org.example.transactions.manager;

import com.google.inject.Singleton;
import org.example.transactions.Transaction;

import java.util.ArrayList;
@Singleton
public class TransactionManager {
    private static ArrayList<Transaction> transactions;

    public TransactionManager() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public ArrayList<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }
}
