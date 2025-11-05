package org.example.facade;

import com.google.inject.Inject;
import org.example.bankAccounts.SavingBankAccount;
import org.example.bankAccounts.services.BankAccountService;
import org.example.services.BankAccountIntrestService;
import org.example.storage.BankAccountStorage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

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

                LocalDateTime today = LocalDateTime.now();
                LocalDateTime lastInterest = ((SavingBankAccount) account).getLastInterestDate();

                //Period period = Period.between(lastInterest, today);
                //int monthsPassed = period.getYears() * 12 + period.getMonths();
                long minutesPassed = ChronoUnit.MINUTES.between(lastInterest, today);

                if (minutesPassed >= 2) {
                    System.out.println("  UUID: " + uuid + ", Account: " + account.getAccountNumber() + " IS SAVING ACCOUNT");
                    double intrestMoney = bankAccountIntrestService.calculateIntrest(account, ((SavingBankAccount) account).interestRate);
                    System.out.println("Current balance: " + account.getBalance() + " + " + intrestMoney + " of intrest");
                    bankAccountService.deposit(account, intrestMoney);
                    System.out.println("Current balance: " + account.getBalance());

                    ((SavingBankAccount) account).getLastInterestDate();
                }
                else {
                    System.out.println("  UUID: " + uuid + ", Account: " + account.getAccountNumber() + " IS SAVING ACCOUNT - NOT YET 2 MINUTES");
                }
            }
            else {
                System.out.println("  UUID: " + uuid + ", Account: " + account.getAccountNumber() + " ISN'T SAVING ACCOUNT");
            }
        });
        System.out.println("--------------------------------");
    }
}
