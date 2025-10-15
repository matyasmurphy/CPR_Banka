package org.example.bankAccounts.numGenerator;

public class NumberGenerator {

    public static int generateNumber() {
        int number = (int)(Math.random() * 101);

        return number;
    }
}
