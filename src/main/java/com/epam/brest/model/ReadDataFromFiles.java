package com.epam.brest.model;

import com.epam.brest.reader.CsvReaderImpl;
import com.epam.brest.reader.Reader;
import com.epam.brest.reader.ValueChecker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.epam.brest.model.StateType.READ_DATA_FROM_FILES;

public class ReadDataFromFiles implements State{

    public static final int NUMBER_OF_USER_DATA = messagesForReadFromFile.size();
    final Scanner scanner;
    List<String> files = new ArrayList<>();

    public ReadDataFromFiles(Scanner scanner, String filePathPricePerKg, String filePathPricePerKm) {
        this.scanner = scanner;
        this.files.add(filePathPricePerKg);
        this.files.add(filePathPricePerKm);
    }

    @Override
    public State handle() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Reader reader = (CsvReaderImpl) applicationContext.getBean("fileReader");

        for (int i = 0; i < NUMBER_OF_USER_DATA; i++) {
            System.out.println(messagesForReadFromFile.get(i));
            String inputValue = scanner.next();
            if (inputValue.equalsIgnoreCase(COMMAND_TO_EXIT)) {
                return new Exit();
            } else if (ValueChecker.isCorrectValue(inputValue)) {

                BigDecimal bigDecimalValue = new BigDecimal(inputValue);
                userData.add(bigDecimalValue);
                userData.add(reader.getValueFromFile(bigDecimalValue, files.get(i)));
            } else {
                return this;
            }
        }
        return new Calculation(scanner, files.get(0), files.get(1));
    }

    @Override
    public StateType getType() {
        return READ_DATA_FROM_FILES;
    }
}
