package org.example.bankAccounts;

import org.example.people.BasePerson;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SavingBankAccount extends BaseBankAccount {
    public double interestRate;
    private LocalDateTime dateOpened;
    private LocalDateTime lastInterestDate;

    public SavingBankAccount(String uuid, String accountNumber, BasePerson owner, double balance, double interestRate) {
        super(uuid, accountNumber,owner,balance);

        this.interestRate = interestRate;
        this.dateOpened =  LocalDateTime.now();
        this.lastInterestDate = LocalDateTime.now();
    }

    public LocalDateTime getDateOpened() {
        return dateOpened;
    }

    public void updateLastInterestDate() {
        this.lastInterestDate = LocalDateTime.now();
    }

    public LocalDateTime getLastInterestDate() {
        return lastInterestDate;
    }
}
