package com.epam.brest.model;
import com.epam.brest.reader.CsvReaderImpl;
import com.epam.brest.reader.Reader;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.epam.brest.model.StatesType.READ_DATA;

public class ReadDataFromFile implements State{

    public static final int NUMBER_OF_USER_DATA = 2;
    final Scanner scanner;
    final String filePath;

    public ReadDataFromFile(Scanner scanner, String filePath) {
        this.scanner = scanner;
        this.filePath = filePath;
    }

    @Override
    public State handle() {
        if (userData.size() < NUMBER_OF_USER_DATA) {
            System.out.println(messages.get(userData.size()));
            String inputValue = scanner.next();
            if (inputValue.equalsIgnoreCase("q")) {
                return new Exit();
            } else if (isCorrectValue(inputValue)) {
                userData.add(new BigDecimal(inputValue));
//                userData.add(reader.getValueFromFile(new BigDecimal(inputValue),filePath));
            }
        } else {
            return new Calculation(scanner);
        }
        return this;
    }

    private boolean isCorrectValue(String inputValue) {
        try {
            BigDecimal enteredValue = new BigDecimal(inputValue);
            return enteredValue.doubleValue() > 0;
        } catch (NumberFormatException nfe) {
            System.out.println("Incorrect value: " + inputValue);
        }
        return false;
    }

    @Override
    public StatesType getType() {
        return READ_DATA;
    }

}
