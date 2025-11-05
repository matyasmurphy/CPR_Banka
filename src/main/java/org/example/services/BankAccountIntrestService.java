package org.example.services;

import org.example.bankAccounts.BaseBankAccount;

public class BankAccountIntrestService {

    public double calculateIntrest(BaseBankAccount bankAccount, double intrestRate) {
        double moneyToAdd = bankAccount.getBalance() * intrestRate;
        return moneyToAdd;
    }
}
