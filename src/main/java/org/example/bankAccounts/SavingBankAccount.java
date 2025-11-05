package org.example.bankAccounts;

import org.example.people.BasePerson;

public class SavingBankAccount extends BaseBankAccount {
    public double interestRate;

    public SavingBankAccount(String uuid, String accountNumber, BasePerson owner, double balance, double interestRate) {
        super(uuid, accountNumber,owner,balance);

        this.interestRate = interestRate;
    }
}
