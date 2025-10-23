package org.example.bankAccounts.services;

import org.example.bankAccounts.BaseBankAccount;
import org.example.logger.Logger;

public class BankAccountService {

    private final Logger logger;

    public BankAccountService(Logger logger) {
        this.logger = logger;
    }
    public void deposit(BaseBankAccount account, double amount) {
        if (amount<= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        System.out.println(account.getUuid() + ": + " + amount);

        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);

        VerifyBankAccount verifyBankAccount = new VerifyBankAccount();
        verifyBankAccount.verifyMoney(account);

        logger.log(account.getUuid() + " | Deposit: +" + amount);
        account.setBalance(account.getBalance() + amount);
    }

    public void withdraw(BaseBankAccount account, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        System.out.println(account.getUuid() + ": - " + amount);
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);

        logger.log(account.getUuid() + " | Withdraw: +" + amount);
        account.setBalance(account.getBalance() + amount);
    }
}
