package com.epam.brest.reader;

import java.math.BigDecimal;

public class ValueChecker {

    public static boolean isCorrectValue(String inputValue) {
        try {
            BigDecimal enteredValue = new BigDecimal(inputValue);
            return enteredValue.doubleValue() > 0;
        } catch (NumberFormatException nfe) {
            System.out.println("Incorrect value: " + inputValue);
        }
        return false;
    }
}
