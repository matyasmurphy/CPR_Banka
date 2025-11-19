package org.example.transactions.generators;

import java.util.UUID;

public class TransactionUuidGen {

    public String generateTransactionUuid() {
        return UUID.randomUUID().toString();
    }
}
