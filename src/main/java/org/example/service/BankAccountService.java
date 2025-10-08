package org.example.service;

import org.example.bankAccounts.BaseBankAccount;

public class BankAccountService {

    public void deposit(BaseBankAccount account, double amount) {
        if (amount<= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        System.out.println(account.getUuid() + ": + " + amount);

        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);

        VerifyBankAccount verifyBankAccount = new VerifyBankAccount();
        verifyBankAccount.verifyMoney(account);
    }

    public void withdraw(BaseBankAccount account, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        System.out.println(account.getUuid() + ": - " + amount);
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
    }
}
