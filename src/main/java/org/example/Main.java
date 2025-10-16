package org.example;

import org.example.bankAccounts.BankAccountWithPaymentCard;
import org.example.cards.PaymentCard;
import org.example.cards.factories.PaymentCardFactory;
import org.example.bankAccounts.factories.BankAccountFactory;
import org.example.cards.services.PaymentCardService;
import org.example.factories.CustomerFactory;
import org.example.bankAccounts.numGenerator.NumberGenerator;
import org.example.people.BankAccountOwner;
import org.example.people.BasePerson;
import org.example.serialization.BankAccountOwnerJsonSerializationService;
import org.example.bankAccounts.services.BankAccountService;
import org.example.bankAccounts.services.VerifyBankAccount;
import org.example.serialization.BankAccountOwnerXmlSerializationService;

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
            PaymentCardService paymentCardService = new PaymentCardService();

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
            System.out.println((""));
            System.out.println("Uuid: " + account.getUuid());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());

            System.out.println((""));
            bankAccountService.deposit(account, 200);
            System.out.println("Balance: " + account.getBalance());

            System.out.println((""));
            bankAccountService.withdraw(account, 50);
            System.out.println("Balance: " + account.getBalance());

            PaymentCardFactory paymentCardFactory = new PaymentCardFactory();
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

            PaymentCard retrievedCard = account.getPaymentCardsMap().get(paymentCard.getCardNumber());
            System.out.println("Card found:");
            System.out.println("    Cislo: " + retrievedCard.getCardNumber());
            System.out.println("    CVV: " + retrievedCard.getCvv());
            System.out.println("    Expirace: " + retrievedCard.getExpirationMonth() + "/" + retrievedCard.getExpirationYear());
            System.out.println("    PIN: " + retrievedCard.getPin());

            BankAccountOwner bankAccountOwner = customerFactory.createBankAccountOwner(
                    "owner-456",
                    "987654321",
                    owner,
                    account.getBalance()
            );

            // JSON serializace
            BankAccountOwnerJsonSerializationService jsonService =
                    new BankAccountOwnerJsonSerializationService();

            System.out.println();
            System.out.println("1) SERIALIZACE DO JSON:");
            String jsonData = jsonService.serialize(bankAccountOwner);
            System.out.println(jsonData);

            // XML serializace
            BankAccountOwnerXmlSerializationService xmlService =
                    new BankAccountOwnerXmlSerializationService();

            System.out.println();
            System.out.println("2) SERIALIZACE DO XML:");
            String xmlData = xmlService.serialize(bankAccountOwner);
            System.out.println(xmlData);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}