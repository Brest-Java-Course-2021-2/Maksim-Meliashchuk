package com.epam.brest;
import com.epam.brest.model.ReadDataFromCon;
import com.epam.brest.model.ReadDataFromFiles;
import com.epam.brest.model.State;
import com.epam.brest.model.StateType;

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

        try (Scanner scanner = new Scanner(System.in)) {

            if(readFromFile) {
                currentStatus = new ReadDataFromFiles(scanner, PRICE_PER_KG_CSV, PRICE_PER_KM_CSV);
            } else {
                currentStatus = new ReadDataFromCon(scanner);
            }

            while (currentStatus.getType() != StateType.EXIT) {
                currentStatus = currentStatus.handle();
            }
        }

    }


}