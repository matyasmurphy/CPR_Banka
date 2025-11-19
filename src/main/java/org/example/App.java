package org.example;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.bankAccounts.BankAccountWithPaymentCard;
import org.example.bankAccounts.SavingBankAccount;
import org.example.bankAccounts.factories.BankAccountFactory;
import org.example.bankAccounts.numGenerator.NumberGenerator;
import org.example.bankAccounts.services.BankAccountService;
import org.example.cards.*;
import org.example.cards.factories.PaymentCardFactory;
import org.example.cards.services.PaymentCardService;
import org.example.cron.IntrestCronService;
import org.example.cron.QuartzSchedulerService;
import org.example.cron.TransactionHistoryJob;
import org.example.factories.CustomerFactory;
import org.example.factories.GuiceJobFactory;
import org.example.logger.Logger;
import org.example.people.BasePerson;
import org.example.services.TransactionHistoryService;
import org.example.storage.BankAccountStorage;
import org.example.transactions.Transaction;
import org.example.transactions.manager.TransactionManager;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;


@Singleton
public class App {
    @Inject
    public NumberGenerator numberGenerator;

    @Inject
    public Logger logger;

    @Inject
    public BankAccountService bankAccountService;

    @Inject
    public PaymentCardFactory paymentCardFactory;

    @Inject
    public BankAccountFactory bankAccountFactory;

    @Inject
    public CustomerFactory customerFactory;

    @Inject
    public PaymentCardService paymentCardService;

    @Inject
    public BankAccountStorage bankAccountStorage;

    @Inject
    public IntrestCronService intrestCronService;

    @Inject
    public TransactionManager transactionManager;

    @Inject
    public TransactionHistoryService transactionHistoryService;

    @Inject
    public GuiceJobFactory  guiceJobFactory;

    @Inject
    public QuartzSchedulerService quartzSchedulerService;

    public void run(){
        try {

            String accountNumber = numberGenerator.generateNumber() + "";
            BasePerson owner = customerFactory.createBaseBankAccountOwner(
                    accountNumber,
                    "John",
                    "Smith"
            );
            BankAccountWithPaymentCard account = bankAccountFactory.createBankAccount(
                    "u-125",
                    accountNumber,
                    owner,
                    100
            );

            SavingBankAccount savingAccount = bankAccountFactory.createSavingBankAccount(
                    "u-123",
                    accountNumber,
                    owner,
                    100,
                    0.4
            );

            System.out.println(("ACCOUNT:"));
            System.out.println("Uuid: " + owner.getUuid());
            System.out.println("Name: " + owner.getFullName());
            System.out.println();
            System.out.println("Uuid: " + account.getUuid());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());

            System.out.println(("SAVING ACCOUNT:"));
            System.out.println("Uuid: " + owner.getUuid());
            System.out.println("Name: " + owner.getFullName());
            System.out.println();
            System.out.println("Uuid: " + savingAccount.getUuid());
            System.out.println("Account Number: " + savingAccount.getAccountNumber());
            System.out.println("Balance: " + savingAccount.getBalance());
            System.out.println("Date Opened: " + savingAccount.getDateOpened());

            System.out.println();
            bankAccountService.deposit(account, 200);
            System.out.println("Balance: " + account.getBalance());

            System.out.println();
            bankAccountService.withdraw(account, 50);
            System.out.println("Balance: " + account.getBalance());

            PaymentCard paymentCard = paymentCardFactory.create(account);

            System.out.println("=== KARTY ===");

            account.addPaymentCard(paymentCard);

            System.out.println("Platebni karta byla pridana k uctu");
            System.out.println("Karta:");
            System.out.println("    Cislo: " + paymentCard.getCardNumber());
            System.out.println("    CVV: " + paymentCard.getCvv());
            System.out.println("    Expirace: " + paymentCard.getExpirationMonth() + "/" + paymentCard.getExpirationYear());
            System.out.println("    PIN: " + paymentCard.getPin());

            System.out.println();
            paymentCardService.pay(paymentCard.getCardNumber(), account, 100);
            System.out.println("Balance after using card: " + account.getBalance());

            System.out.println();
            System.out.println("=== BANK ACCOUNT STORAGE ===");
            System.out.println("Stored accounts: " + bankAccountStorage.getBankAccountsMap().size());
            bankAccountStorage.getBankAccountsMap().forEach((uuid, acc) -> {
                System.out.println("  UUID: " + uuid + ", Account: " + acc.getAccountNumber());
            });
            System.out.println("--------------------------------");
            System.out.println("TRANSACTIONS");
            ArrayList<Transaction> transactions = transactionManager.getTransactions();
            System.out.println("Number of transactions: " + transactions.size());

            for (Transaction transaction : transactions) {
                System.out.println("  Date: " + transaction.getDate());
                System.out.println("  Account: " + transaction.getAccountUuid());
                System.out.println("  Type: " + transaction.getTransactionType());
                System.out.println("  Amount: " + transaction.getAmount());
                System.out.println("  ---");
            }
            System.out.println("--------------------------------");

            intrestCronService.IntrestTimer();

            try {
                Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

                scheduler.setJobFactory(guiceJobFactory);
                scheduler.start();

                quartzSchedulerService.scheduleJob(scheduler, TransactionHistoryJob.class, "group", 1);
            } catch (SchedulerException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
