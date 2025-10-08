package org.example.bankAccounts;

import org.example.people.BasePerson;

public class SavingBankAccount extends BaseBankAccount {

    public SavingBankAccount(String uuid, String accountNumber, BasePerson owner, double balance) {
        super(uuid, accountNumber,owner,balance);


    }
}
