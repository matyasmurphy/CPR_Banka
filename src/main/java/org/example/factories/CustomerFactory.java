package org.example.factories;

import org.example.people.BankAccountOwner;
import org.example.people.BasePerson;
import org.example.people.Student;

public class CustomerFactory {

    public BasePerson createBaseBankAccountOwner(String uuid, String firstName, String lastName){
        return new BasePerson(uuid, firstName, lastName);
    }

    public BankAccountOwner createBankAccountOwner(String uuid, String accountNumber, BasePerson owner, double balance){
        return new BankAccountOwner(uuid, accountNumber, owner, balance);
    }

    public Student createStudent(String uuid, String firstName, String lastName, String school){
        return new Student(uuid, firstName, lastName, school);
    }
}
