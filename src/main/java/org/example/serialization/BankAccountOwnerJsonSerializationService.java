package org.example.serialization;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.people.BankAccountOwner;
import org.example.people.BasePerson;
import org.example.people.serialization.BankAccountOwnerSerialization;
import org.example.people.serialization.BankAccountSerializationFactory;

@Singleton
public class BankAccountOwnerJsonSerializationService implements Serialization {
    @Inject
    BankAccountSerializationFactory bankAccountSerializationFactory;
    @Inject
    Gson gson;

    @Override
    public String serialize(Object bankAccountOwner) {
        if (!(bankAccountOwner instanceof BankAccountOwner)) {
            throw new IllegalArgumentException("BankAccountOwner must be of type BankAccountOwner");
        }

        BankAccountOwnerSerialization bankAccountOwnerSerialization =
                bankAccountSerializationFactory.createBankAccountOwnerSerialization(
                        ((BankAccountOwner) bankAccountOwner).getOwner()
                );

        return gson.toJson(bankAccountOwnerSerialization);
    }

    @Override
    public Object deserialize(String serializedData) {
        return gson.fromJson(serializedData, BankAccountOwnerSerialization.class);
    }
}