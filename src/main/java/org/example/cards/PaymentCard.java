package org.example.cards;

import org.example.bankAccounts.BankAccountWithPaymentCard;

public class PaymentCard {
    private String uuid;
    private String cardNumber;
    private String cvv;
    private String pin;
    private String expirationMonth;
    private String expirationYear;
    private BankAccountWithPaymentCard bankAccount;

    public PaymentCard(String uuid, String cardNumber, String cvv, String pin, String expirationMonth, String expirationYear, BankAccountWithPaymentCard bankAccount) {
        this.uuid = uuid;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.pin = pin;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.bankAccount = bankAccount;
    }

    public String getUuid() {
        return uuid;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public String getPin() {
        return pin;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public BankAccountWithPaymentCard getBankAccount() {
        return bankAccount;
    }
}
