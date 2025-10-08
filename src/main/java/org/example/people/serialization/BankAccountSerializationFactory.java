package org.example.people.serialization;

import org.example.people.BasePerson;

public class BankAccountSerializationFactory {

    public BankAccountOwnerSerialization createBankAccountOwnerSerialization(BasePerson basePerson) {
        BankAccountOwnerSerialization bankAccountOwnerSerialization = new BankAccountOwnerSerialization();

        bankAccountOwnerSerialization.uuid = basePerson.getUuid();
        bankAccountOwnerSerialization.firstName = basePerson.getName();
        bankAccountOwnerSerialization.lastName = basePerson.getLastName();

        return bankAccountOwnerSerialization;
    }
}
