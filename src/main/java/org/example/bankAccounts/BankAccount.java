package org.example.bankAccounts;

import org.example.people.BasePerson;

import java.util.HashMap;

public class BankAccount extends BankAccountWithPaymentCard {
    public BankAccount(String uuid, String accountNumber, BasePerson owner, double balance) {
        super(uuid,accountNumber,owner,balance);

        this.paymentCardsMap = new HashMap<>();
    }
}
