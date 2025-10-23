package org.example.bankAccounts;

import org.example.cards.PaymentCard;
import org.example.people.BasePerson;

import java.util.HashMap;
import java.util.Map;

public class BankAccountWithPaymentCard extends BaseBankAccount{
    protected Map<String, PaymentCard> paymentCardsMap;

    public BankAccountWithPaymentCard(String uuid, String accountNumber, BasePerson owner, double balance) {
        super(uuid,accountNumber,owner,balance);

        this.paymentCardsMap = new HashMap<>();
    }

    public void addPaymentCard(PaymentCard paymentCard) {
        this.paymentCardsMap.put(paymentCard.getCardNumber(), paymentCard);
    }

    public Map<String, PaymentCard> getPaymentCardsMap() {
        return new HashMap<>(paymentCardsMap);
    }
}
