package com.epam.brest;
import com.epam.brest.model.ReadDataFromCon;
import com.epam.brest.model.ReadDataFromFiles;
import com.epam.brest.model.State;
import com.epam.brest.model.StateType;
import com.epam.brest.reader.CsvReaderImpl;
import com.epam.brest.reader.Reader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {

        final String PRICE_PER_KG_CSV = "pricePerKg.csv";
        final String PRICE_PER_KM_CSV = "pricePerKm.csv";
        State currentStatus;

        boolean readFromFile = false;
        if (arg.length == 1 && arg[0].equals("-csv")) {
            readFromFile = true;
        }
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        ReadDataFromCon readerConsole = (ReadDataFromCon) applicationContext.getBean("readerFromCon");

        try (Scanner scanner = new Scanner(System.in)) {


            if(readFromFile) {
                currentStatus = new ReadDataFromFiles(scanner, PRICE_PER_KG_CSV, PRICE_PER_KM_CSV);
            } else {
                readerConsole.setScanner(scanner);
                currentStatus = readerConsole;
            }

            while (currentStatus.getType() != StateType.EXIT) {
                currentStatus = currentStatus.handle();
            }
        }

    }


}