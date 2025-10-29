package org.example.bankAccounts.numGenerator;

import com.google.inject.Singleton;

@Singleton
public class NumberGenerator {

    public int generateNumber() {
        int number = (int)(Math.random() * 101);

        return number;
    }
}
