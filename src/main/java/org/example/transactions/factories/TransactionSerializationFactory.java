package org.example.transactions.factories;

import com.google.inject.Singleton;
import org.example.transactions.Transaction;
import org.example.transactions.TransactionSerialization;

@Singleton
public class TransactionSerializationFactory {

    public TransactionSerialization createTransactionSerialization(Transaction transaction) {
        TransactionSerialization transactionSerialization = new TransactionSerialization();

        transactionSerialization.date = transaction.getDate();
        transactionSerialization.uuid = transaction.getUuid();
        transactionSerialization.accountUuid = transaction.getAccountUuid();
        transactionSerialization.transactionType = transaction.getTransactionType();
        transactionSerialization.amount = transaction.getAmount();

        return transactionSerialization;
    }
}
