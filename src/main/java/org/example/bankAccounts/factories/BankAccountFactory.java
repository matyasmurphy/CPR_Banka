package org.example.bankAccounts.factories;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.bankAccounts.BankAccount;
import org.example.bankAccounts.SavingBankAccount;
import org.example.bankAccounts.StudentBankAccount;
import org.example.bankAccounts.numGenerator.NumberGenerator;
import org.example.people.BasePerson;

@Singleton
public class BankAccountFactory {

    @Inject
    private NumberGenerator NumberGenerator;

    public BankAccount createBankAccount(String uuid, String accountNumber, BasePerson owner, double balance) {
        return new BankAccount(uuid, accountNumber, owner, balance);
    }

    public SavingBankAccount createSavingBankAccount(String uuid, String accountNumber, BasePerson owner, double balance) {
        return new SavingBankAccount(uuid, accountNumber, owner, balance);
    }

    public StudentBankAccount createStudentBankAccount(String uuid, String accountNumber, BasePerson owner, double balance, String schoolName) {
        return new StudentBankAccount(uuid, accountNumber, owner, balance, schoolName);
    }

}
