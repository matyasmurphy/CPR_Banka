package org.example.factories;

import org.example.bankAccounts.BankAccount;
import org.example.bankAccounts.SavingBankAccount;
import org.example.bankAccounts.StudentBankAccount;
import org.example.people.BankAccountOwner;
import org.example.people.BaseBankAccountOwner;

public class BankAccountFactory {

    public BankAccount createBankAccount(String uuid, String accountNumber, BaseBankAccountOwner owner, double balance) {
        return new BankAccount(uuid, accountNumber, owner, balance);
    }

    public SavingBankAccount createSavingBankAccount(String uuid, String accountNumber, BaseBankAccountOwner owner, double balance) {
        return new SavingBankAccount(uuid, accountNumber, owner, balance);
    }

    public StudentBankAccount createStudentBankAccount(String uuid, String accountNumber, BaseBankAccountOwner owner, double balance, String schoolName) {
        return new StudentBankAccount(uuid, accountNumber, owner, balance, schoolName);
    }

}
