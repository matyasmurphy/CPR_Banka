package org.example.numGenerator;

public class NumberGenerator {

    public static int GenerateNumber() {
        int number = (int)(Math.random() * 101);

        return number;
    }
}
