package org.example.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.people.BankAccountOwner;
import org.example.people.BasePerson;
import org.example.people.serialization.BankAccountOwnerSerialization;
import org.example.people.serialization.BankAccountSerializationFactory;

public class BankAccountOwnerXmlSerializationService implements Serialization {

    private final BankAccountSerializationFactory bankAccountSerializationFactory;
    private final XmlMapper xmlMapper;

    public BankAccountOwnerXmlSerializationService() {
        this.bankAccountSerializationFactory = new BankAccountSerializationFactory();
        this.xmlMapper = new XmlMapper();
    }

    @Override
    public String serialize(Object bankAccountOwner) {
        if (!(bankAccountOwner instanceof BankAccountOwner)) {
            throw new IllegalArgumentException("BankAccountOwner must be of type BankAccountOwner");
        }

        BankAccountOwnerSerialization bankAccountOwnerSerialization =
                bankAccountSerializationFactory.createBankAccountOwnerSerialization(
                        ((BankAccountOwner) bankAccountOwner).getOwner()
                );

        try {
            return xmlMapper.writeValueAsString(bankAccountOwnerSerialization);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize to XML", e);
        }
    }

    @Override
    public Object deserialize(String serializedData) {
        try {
            return xmlMapper.readValue(serializedData, BankAccountOwnerSerialization.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize from XML", e);
        }
    }
}