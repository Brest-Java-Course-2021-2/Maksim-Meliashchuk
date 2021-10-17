package com.epam.brest.model;

import com.epam.brest.reader.ValueChecker;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.epam.brest.model.StatesType.READ_DATA_FROM_CON;

public class ReadDataFromCon implements State {

    public static final int NUMBER_OF_USER_DATA = messagesForConInput.size();
    final Scanner scanner;

    public ReadDataFromCon(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public State handle() {
        if (userData.size() < NUMBER_OF_USER_DATA) {
            System.out.println(messagesForConInput.get(userData.size()));
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
        return READ_DATA_FROM_CON;
    }

}
