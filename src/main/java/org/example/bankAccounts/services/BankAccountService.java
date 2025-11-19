package org.example.bankAccounts.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.bankAccounts.BaseBankAccount;
import org.example.logger.Logger;
import org.example.transactions.Transaction;
import org.example.transactions.factories.TransactionFactory;
import org.example.transactions.TransactionTypes;

import java.time.LocalDateTime;
import java.util.Date;

@Singleton
public class BankAccountService {

    @Inject
    private TransactionFactory transactionFactory;
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

        Transaction transaction = transactionFactory.createTransaction(new Date(), account.getUuid(), TransactionTypes.DEPOSIT, amount);
        logger.log(account.getUuid() + " | Deposit: +" + amount);
    }

    public void withdraw(BaseBankAccount account, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        System.out.println(account.getUuid() + ": - " + amount);
        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);

        Transaction transaction = transactionFactory.createTransaction(new Date(), account.getUuid(), TransactionTypes.WITHDRAW, amount);
        logger.log(account.getUuid() + " | Withdraw: -" + amount);
    }
}
