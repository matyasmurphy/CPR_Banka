package org.example.bankAccounts.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.bankAccounts.BaseBankAccount;
import org.example.bankAccounts.factories.BankAccountFactory;
import org.example.logger.ConsoleLogger;
import org.example.logger.Logger;

import java.util.Map;

@Singleton
public class BankAccountService {

    @Inject
    private Logger logger;

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
    }

    public void withdraw(BaseBankAccount account, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        System.out.println(account.getUuid() + ": - " + amount);
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);

        logger.log(account.getUuid() + " | Withdraw: -" + amount);
    }
}
