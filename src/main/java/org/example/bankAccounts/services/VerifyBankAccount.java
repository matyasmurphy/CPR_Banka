package org.example.bankAccounts.services;

import com.google.inject.Singleton;
import org.example.bankAccounts.BaseBankAccount;
@Singleton
public class VerifyBankAccount {

    public void verifyMoney(BaseBankAccount baseBankAccount) {

        if (baseBankAccount.getBalance() >= 10000) {
            System.out.println("Bank account balance is greater than 10000");
        }
    }
}
