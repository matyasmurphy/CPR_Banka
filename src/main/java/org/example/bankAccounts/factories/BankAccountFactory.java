package org.example.bankAccounts.factories;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.bankAccounts.BankAccount;
import org.example.bankAccounts.BankAccountWithPaymentCard;
import org.example.bankAccounts.SavingBankAccount;
import org.example.bankAccounts.StudentBankAccount;
import org.example.bankAccounts.numGenerator.NumberGenerator;
import org.example.people.BasePerson;
import org.example.storage.BankAccountStorage;

@Singleton
public class BankAccountFactory {

    @Inject
    private NumberGenerator numberGenerator;

    @Inject
    private BankAccountStorage bankAccountStorage;

    public BankAccount createBankAccount(String uuid, String accountNumber, BasePerson owner, double balance) {
        BankAccount account = new BankAccount(uuid, accountNumber, owner, balance);
        bankAccountStorage.addBankAccount(account);
        System.out.println("Account Added: " + account);
        return account;
    }

    public SavingBankAccount createSavingBankAccount(String uuid, String accountNumber, BasePerson owner, double balance, double interestRate) {
        SavingBankAccount account = new SavingBankAccount(uuid, accountNumber, owner, balance, interestRate);
        bankAccountStorage.addBankAccount(account);
        System.out.println("Account Added: " + account);
        return account;
    }

    public StudentBankAccount createStudentBankAccount(String uuid, String accountNumber, BasePerson owner, double balance, String schoolName) {
        StudentBankAccount account = new StudentBankAccount(uuid, accountNumber, owner, balance, schoolName);
        bankAccountStorage.addBankAccount(account);
        System.out.println("Account Added: " + account);
        return account;
    }

}
