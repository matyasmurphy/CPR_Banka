package org.example;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.bankAccounts.BankAccountWithPaymentCard;
import org.example.bankAccounts.factories.BankAccountFactory;
import org.example.bankAccounts.numGenerator.NumberGenerator;
import org.example.bankAccounts.services.BankAccountService;
import org.example.cards.*;
import org.example.cards.factories.PaymentCardFactory;
import org.example.cards.services.PaymentCardService;
import org.example.factories.CustomerFactory;
import org.example.logger.Logger;
import org.example.people.BasePerson;


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

    public void run(){
        try {

            String accountNumber = numberGenerator.generateNumber() + "";
            BasePerson owner = customerFactory.createBaseBankAccountOwner(
                    accountNumber,
                    "John",
                    "Smith"
            );
            BankAccountWithPaymentCard account = bankAccountFactory.createBankAccount(
                    "u-123",
                    accountNumber,
                    owner,
                    100
            );
            System.out.println(("ACCOUNT:"));
            System.out.println("Uuid: " + owner.getUuid());
            System.out.println("Name: " + owner.getFullName());
            System.out.println();
            System.out.println("Uuid: " + account.getUuid());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());

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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
