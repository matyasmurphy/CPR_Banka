package org.example.cards.services;

import org.example.bankAccounts.BankAccountWithPaymentCard;
import org.example.bankAccounts.services.BankAccountService;
import org.example.cards.PaymentCard;
import org.example.logger.Logger;

public class PaymentCardService {
    Logger logger = new Logger();
    BankAccountService bankAccountService = new BankAccountService(logger);

    public void pay(String cardNumber, BankAccountWithPaymentCard account, double amount) {
        PaymentCard card = account.getPaymentCardsMap().get(cardNumber);

        if (card == null) {
            throw new IllegalArgumentException("Card not found");
        }

        if (!card.getBankAccount().equals(account)) {
            throw new IllegalArgumentException("Card does not belong to this account");
        }

        bankAccountService.withdraw(account, amount);

        System.out.println("Payment of " + amount + " using card " + cardNumber);
    }
}