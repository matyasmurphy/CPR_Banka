package org.example.cards;

import java.util.UUID;

public class PaymentCardFactory {

    private final PaymentCardNumberGenerator paymentCardNumberGenerator = new PaymentCardNumberGenerator();
    private final PaymentCardCvvGenerator paymentCardCvvGenerator = new PaymentCardCvvGenerator();
    private final PaymentCardPinGenerator paymentCardPinGenerator = new PaymentCardPinGenerator();
    private final PaymentCardExirationCalculator paymentCardExirationCalculator = new PaymentCardExirationCalculator();

    public PaymentCard create() {
        String uuid = UUID.randomUUID().toString();
        String cardNumber = this.paymentCardNumberGenerator.generateNumber();
        String cvv = this.paymentCardCvvGenerator.generateCardCvv();
        String pin = this.paymentCardPinGenerator.generatePin(); // neni zacifrovany
        String expirationMonth = paymentCardExirationCalculator.calculateExpirationMonth();
        String expirationYear = paymentCardExirationCalculator.calculateExpirationYear();

        PaymentCard paymentCard = new PaymentCard(uuid, cardNumber, cvv, pin, expirationMonth, expirationYear);

        return paymentCard;
    }
}
