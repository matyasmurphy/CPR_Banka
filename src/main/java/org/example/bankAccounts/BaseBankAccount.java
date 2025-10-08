package org.example.bankAccounts;

import org.example.people.BasePerson;

public class BaseBankAccount {

    private String uuid;

    private String accountNumber;

    private BasePerson owner;

    double balance;

    public BaseBankAccount(String uuid, String accountNumber, BasePerson owner, double balance) {
        this.uuid = uuid;
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }
    public String getUuid() {
        return uuid;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BasePerson getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    /*
    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void withdraw(double balance) {
        double subtract = this.balance - balance;
        if (subtract > 0) {
            throw new IllegalArgumentException("Insufficient funds.");
        }

        this.balance = subtract;
    }
     */
}
