package org.example.serialization;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.transactions.Transaction;
import org.example.transactions.TransactionSerialization;
import org.example.transactions.factories.TransactionSerializationFactory;

import java.io.Serializable;

@Singleton
public class TransactionSerializationJsonService implements Serialization {

    @Inject
    private TransactionSerializationFactory transactionSerializationFactory;

    @Inject
    private Gson gson;

    @Override
    public String serialize(Object transaction) {
        if (!(transaction instanceof Transaction)) {
            throw new ClassCastException("Object is not an instance of Transaction");
        }

        TransactionSerialization transactionSerialization = transactionSerializationFactory.createTransactionSerialization((Transaction) transaction);
        return gson.toJson(transactionSerialization);
    }

    @Override
    public Object deserialize(String serializedData) {
        return gson.fromJson(serializedData, TransactionSerialization.class);
    }
}
