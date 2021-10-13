package com.epam.brest;
import com.epam.brest.calc.Calc;
import com.epam.brest.reader.CsvReaderImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {
        Boolean readFromFile = false;

        final String PRICE_PER_KG_CSV = "src/main/resources/pricePerKg.csv";
        final String PRICE_PER_KM_CSV = "src/main/resources/pricePerKm.csv";

        if (arg.length == 1 && arg[0].equals("-csv")) {
            readFromFile = true;
        }

        BigDecimal weight, pricePerKg, length, pricePerKm;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                if(readFromFile) {
                    CsvReaderImpl csvReader = new CsvReaderImpl();
                    weight = getValueFromCon(scanner, "Enter weight:");
                    pricePerKg = csvReader.getValueFromFile(weight, PRICE_PER_KG_CSV);
                    length = getValueFromCon(scanner, "Enter length:");
                    pricePerKm = csvReader.getValueFromFile(length, PRICE_PER_KM_CSV);
                } else {
                    weight = getValueFromCon(scanner, "Enter weight:");
                    pricePerKg = getValueFromCon(scanner, "Enter pricePerKg:");
                    length = getValueFromCon(scanner, "Enter length:");
                    pricePerKm = getValueFromCon(scanner, "Enter pricePerKm:");
                }
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
            System.out.println("Enter 'q' for exit or 'c' to continue!");
            userChoice = scanner.next();
        }
        return userChoice;
    }

}