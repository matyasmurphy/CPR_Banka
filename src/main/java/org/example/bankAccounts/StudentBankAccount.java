package org.example.bankAccounts;

import org.example.people.BaseBankAccountOwner;

public class StudentBankAccount extends BaseBankAccount{
    public StudentBankAccount(String uuid, String accountNumber, BaseBankAccountOwner owner, double balance) {
        super(uuid, accountNumber, owner, balance);
    }
}
