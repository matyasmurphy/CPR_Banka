package org.example.factories;

import org.example.bankAccounts.BankAccount;
import org.example.people.BankAccountOwner;
import org.example.people.BaseBankAccountOwner;
import org.example.people.Student;

public class CustomerFactory {

    public BaseBankAccountOwner createBaseBankAccountOwner(String uuid, String firstName, String lastName){
        return new BaseBankAccountOwner(uuid, firstName, lastName);
    }

    public BankAccountOwner createBankAccountOwner(String uuid, String accountNumber, BaseBankAccountOwner owner, double balance){
        return new BankAccountOwner(uuid, accountNumber, owner, balance);
    }

    public Student createStudent(String uuid, String firstName, String lastName, String school){
        return new Student(uuid, firstName, lastName, school);
    }
}
