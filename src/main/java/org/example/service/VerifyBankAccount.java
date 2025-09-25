package org.example.service;

import org.example.bankAccounts.BaseBankAccount;

public class VerifyBankAccount {

    public void verifyMoney(BaseBankAccount baseBankAccount) {

        if (baseBankAccount.getBalance() >= 10000) {
            System.out.println("Bank account balance is greater than 10000");
        }
    }
}
