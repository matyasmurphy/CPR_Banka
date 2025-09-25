package org.example;

import org.example.bankAccounts.BaseBankAccount;
import org.example.bankAccounts.StudentBankAccount;
import org.example.factories.BankAccountFactory;
import org.example.factories.CustomerFactory;
import org.example.numGenerator.NumberGenerator;
import org.example.people.BaseBankAccountOwner;
import org.example.people.Student;
import org.example.service.BankAccountService;
import org.example.service.VerifyBankAccount;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String accountNumber = NumberGenerator.generateNumber() + "";

        try {
            BankAccountService bankAccountService = new BankAccountService();
            BankAccountFactory bankAccountFactory = new BankAccountFactory();
            CustomerFactory customerFactory = new CustomerFactory();
            VerifyBankAccount verifyBankAccount = new VerifyBankAccount();

            BaseBankAccountOwner owner = customerFactory.createBaseBankAccountOwner(
                    accountNumber,
                    "John",
                    "Smith"
            );
            BaseBankAccount account = bankAccountFactory.createBankAccount(
                    "u-123",
                    accountNumber,
                    owner,
                    100
            );
            System.out.println(("ACCOUNT:"));
            System.out.println("Uuid: " + owner.getUuid());
            System.out.println("Name: " + owner.getFullName());
            System.out.println((""));
            System.out.println("Uuid: " + account.getUuid());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());

            System.out.println((""));
            bankAccountService.deposit(account, 100000);
            System.out.println("Balance: " + account.getBalance());

            System.out.println((""));
            bankAccountService.withdraw(account, 50);
            System.out.println("Balance: " + account.getBalance());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
    /*
    private static BaseBankAccount testBankAccount(BaseBankAccountOwner owner) {
        BankAccountService bankAccountService = new BankAccountService();
        BankAccountFactory bankAccountFactory = new BankAccountFactory();

        String accountNumber = NumberGenerator.generateNumber() + "";

        BaseBankAccount account = bankAccountFactory.createBankAccount(
                "u-123",
                accountNumber,
                owner,
                100
        );

        try {
            System.out.println("Uuid: " + owner.getUuid());
            System.out.println("Name: " + owner.getFullName());
            System.out.println("School: " + ((Student) owner).getSchool());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}   */