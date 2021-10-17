package com.epam.brest.model;

import com.epam.brest.reader.ValueChecker;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.epam.brest.model.StatesType.READ_DATA;

public class ReadDataFromFile implements State{

    public static final int NUMBER_OF_USER_DATA = messagesForReadFromFile.size();
    final Scanner scanner;
    String filePath;

    public ReadDataFromFile(Scanner scanner, String filePath) {
        this.scanner = scanner;
        this.filePath = filePath;
    }

    @Override
    public State handle() {
        if (userData.size() < NUMBER_OF_USER_DATA) {
            System.out.println(messagesForReadFromFile.get(userData.size()));
            String inputValue = scanner.next();
            if (inputValue.equalsIgnoreCase(COMMAND_TO_EXIT)) {
                return new Exit();
            } else if (ValueChecker.isCorrectValue(inputValue)) {
                userData.add(new BigDecimal(inputValue));
            }
        } else {
            return new Calculation(scanner);
        }
        return this;
    }

    @Override
    public StatesType getType() {
        return READ_DATA;
    }
}
