package org.example.bankAccounts;

import org.example.people.BasePerson;

public class BankAccount extends BaseBankAccount {

    public BankAccount(String uuid, String accountNumber, BasePerson owner, double balance) {
        super(uuid,accountNumber,owner,balance);
    }
}
