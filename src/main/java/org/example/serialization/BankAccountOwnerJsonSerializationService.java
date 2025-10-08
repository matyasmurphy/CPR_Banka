package org.example.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import org.example.people.BankAccountOwner;
import org.example.people.BasePerson;
import org.example.people.serialization.BankAccountOwnerSerialization;
import org.example.people.serialization.BankAccountSerializationFactory;

public class BankAccountOwnerJsonSerializationService implements Serialization {

    BankAccountSerializationFactory bankAccountSerializationFactory = new BankAccountSerializationFactory();
    Gson gson = new Gson();


    @Override
    public String serialize(Object bankAccountOwner) {
        if (!(bankAccountOwner instanceof BankAccountOwner)) {
            throw new IllegalArgumentException("BankAccountOwner must be of type BankAccountOwner");
        }

        BankAccountOwnerSerialization bankAccountOwnerSerialization = bankAccountSerializationFactory.createBankAccountOwnerSerialization(((BankAccountOwner) bankAccountOwner).getOwner());

        return gson.toJson(bankAccountOwnerSerialization);
    }

    public String serializeXml(Object bankAccountOwner) {
        if (!(bankAccountOwner instanceof BankAccountOwner)) {
            throw new IllegalArgumentException("BankAccountOwner must be of type BankAccountOwner");
        }

        BankAccountOwnerSerialization bankAccountOwnerSerialization = bankAccountSerializationFactory.createBankAccountOwnerSerialization(((BankAccountOwner) bankAccountOwner).getOwner());

        XmlMapper xmlMapper = new XmlMapper();
        try {
            return xmlMapper.writeValueAsString(bankAccountOwnerSerialization);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public Object deserialize(String serializedData) {
        return gson.fromJson(serializedData, BankAccountOwnerSerialization.class);
    }

    public static void main(String[] args) {
        BankAccountOwnerJsonSerializationService service = new BankAccountOwnerJsonSerializationService();
        System.out.println(service.serializeXml(new BankAccountOwner("101", "100", new BasePerson("100","Tomas", "Krtecek"), 100)));
    }
}
