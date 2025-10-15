package org.example.bankAccounts.factories;

import org.example.bankAccounts.BankAccount;
import org.example.bankAccounts.SavingBankAccount;
import org.example.bankAccounts.StudentBankAccount;
import org.example.people.BasePerson;

public class BankAccountFactory {

    public BankAccount createBankAccount(String uuid, String accountNumber, BasePerson owner, double balance) {
        return new BankAccount(uuid, accountNumber, owner, balance);
    }

    public SavingBankAccount createSavingBankAccount(String uuid, String accountNumber, BasePerson owner, double balance) {
        return new SavingBankAccount(uuid, accountNumber, owner, balance);
    }

    public StudentBankAccount createStudentBankAccount(String uuid, String accountNumber, BasePerson owner, double balance, String schoolName) {
        return new StudentBankAccount(uuid, accountNumber, owner, balance, schoolName);
    }

}
