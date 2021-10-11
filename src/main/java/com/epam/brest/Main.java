package com.epam.brest;
import com.epam.brest.calc.Calc;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {

        BigDecimal weight, pricePerKg, length, pricePerKm;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                weight = getValueFromCon(scanner, "Enter weight:");
                pricePerKg = getValueFromCon(scanner, "Enter pricePerKg:");
                length = getValueFromCon(scanner, "Enter length:");
                pricePerKm = getValueFromCon(scanner, "Enter pricePerKm:");
                System.out.println("Result:" + Calc.handle(weight, pricePerKg, length, pricePerKm));
                System.out.println("Enter 'q' for exit or 'c' to continue:");
            } while (userChoice(scanner).equals("c"));
        }
    }

    private static BigDecimal getValueFromCon(Scanner scanner, String outputMessage) {
        BigDecimal enteredValue;
        System.out.print(outputMessage);
        enteredValue = scanner.nextBigDecimal();
        return enteredValue;
    }

    private static String userChoice(Scanner scanner) {
        String userChoice = scanner.next();
        while (!userChoice.equals("q") && !userChoice.equals("c")) {
            userChoice = scanner.next();
        }
        return userChoice;
    }

}