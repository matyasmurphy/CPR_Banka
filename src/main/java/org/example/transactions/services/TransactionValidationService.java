package org.example.transactions.services;

import org.example.bankAccounts.BaseBankAccount;

public class TransactionValidationService {

    private final int AML_CHECK_LIMIT = 10000;

    public void validateDepositTransaction(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit/Withdrawal amount must be positive.");

        amlCheck(amount);
    }

    public void validateWithdrawalTransaction(BaseBankAccount account, double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit/Withdrawal amount must be positive.");

        if (amount > account.getBalance())
            throw new IllegalArgumentException("Withdrawal amount must not be greater than account's balance.");
    }

    public void amlCheck(double amount) {
        if (amount > AML_CHECK_LIMIT)
            throw new IllegalArgumentException("Transaction flagged for AML review.");
    }
}
