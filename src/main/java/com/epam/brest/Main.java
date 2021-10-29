package com.epam.brest;
import com.epam.brest.model.ReadDataFromCon;
import com.epam.brest.model.ReadDataFromFiles;
import com.epam.brest.model.State;
import com.epam.brest.model.StateType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        State currentStatus;

        boolean readFromFile = arg.length == 1 && arg[0].equals("-csv");

        ReadDataFromCon readerConsole = (ReadDataFromCon) applicationContext.getBean("readerFromCon");

        try (Scanner scanner = new Scanner(System.in)) {


            if(readFromFile) {
                ReadDataFromFiles readDataFromFiles = (ReadDataFromFiles) applicationContext
                        .getBean("readerFromFiles");
                ReadDataFromFiles.setScanner(scanner);
                currentStatus = readDataFromFiles;
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