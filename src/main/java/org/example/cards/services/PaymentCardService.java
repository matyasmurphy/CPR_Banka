package org.example.cards.services;

import org.example.bankAccounts.BankAccountWithPaymentCard;
import org.example.bankAccounts.services.BankAccountService;
import org.example.cards.PaymentCard;

public class PaymentCardService {

    BankAccountService bankAccountService = new BankAccountService();

    public void pay(PaymentCard paymentCard, double amount) {
        BankAccountWithPaymentCard bankAccount = paymentCard.getBankAccount();
        bankAccountService.withdraw(bankAccount, amount);
    }
}
