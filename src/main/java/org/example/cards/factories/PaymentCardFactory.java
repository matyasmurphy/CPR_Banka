package org.example.cards.factories;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.bankAccounts.BankAccountWithPaymentCard;
import org.example.cards.*;
import org.example.cards.services.PaymentCardService;

import java.util.UUID;
@Singleton
public class PaymentCardFactory {
    @Inject
    private PaymentCardNumberGenerator paymentCardNumberGenerator;
    @Inject
    private PaymentCardCvvGenerator paymentCardCvvGenerator;
    @Inject
    private PaymentCardPinGenerator paymentCardPinGenerator;
    @Inject
    private PaymentCardExirationCalculator paymentCardExirationCalculator;


    public PaymentCard create(BankAccountWithPaymentCard bankAccount) {
        String uuid = UUID.randomUUID().toString();
        String cardNumber = this.paymentCardNumberGenerator.generateNumber();
        String cvv = this.paymentCardCvvGenerator.generateCardCvv();
        String pin = this.paymentCardPinGenerator.generatePin(); // neni zacifrovany
        String expirationMonth = paymentCardExirationCalculator.calculateExpirationMonth();
        String expirationYear = paymentCardExirationCalculator.calculateExpirationYear();

        PaymentCard paymentCard = new PaymentCard(uuid, cardNumber, cvv, pin, expirationMonth, expirationYear, bankAccount);

        return paymentCard;
    }
}
