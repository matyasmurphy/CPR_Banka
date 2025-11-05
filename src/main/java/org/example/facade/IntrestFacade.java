package org.example.facade;

import com.google.inject.Inject;
import org.example.bankAccounts.SavingBankAccount;
import org.example.bankAccounts.services.BankAccountService;
import org.example.services.BankAccountIntrestService;
import org.example.storage.BankAccountStorage;

public class IntrestFacade {

    @Inject
    private BankAccountStorage bankAccountStorage;

    @Inject
    private BankAccountService bankAccountService;

    @Inject
    private BankAccountIntrestService bankAccountIntrestService;

    public void isSavingsAccount(){
        System.out.println("--------------------------------");
        System.out.println("SAVINGS");
        bankAccountStorage.getBankAccountsMap().forEach((uuid, account) -> {
            if (account instanceof SavingBankAccount){
                System.out.println("  UUID: " + uuid + ", Account: " + account.getAccountNumber() + " IS SAVING ACCOUNT");
                double intrestMoney = bankAccountIntrestService.calculateIntrest(account, ((SavingBankAccount) account).interestRate);
                System.out.println("Current balance: " + account.getBalance() + " + " + intrestMoney + " of intrest");
                bankAccountService.deposit(account, intrestMoney);
                System.out.println("Current balance: " + account.getBalance());
            }
            else {
                System.out.println("  UUID: " + uuid + ", Account: " + account.getAccountNumber() + " ISN'T SAVING ACCOUNT");
            }
        });
        System.out.println("--------------------------------");
    }
}
