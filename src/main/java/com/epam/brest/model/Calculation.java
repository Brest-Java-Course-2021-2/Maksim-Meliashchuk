package com.epam.brest.model;

import com.epam.brest.calc.CalcImpl;
import com.epam.brest.calc.Calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.epam.brest.model.StateType.CALC;

public class Calculation implements State {
    Scanner scanner;
    List<String> files = new ArrayList<>();

    public Calculation(Scanner scanner) {
        this.scanner = scanner;
        this.files = null;
    }

    public Calculation(Scanner scanner, String filePathPricePerKg, String filePathPricePerKm) {
        this.scanner = scanner;
        this.files.add(filePathPricePerKg);
        this.files.add(filePathPricePerKm);
    }

    @Override
    public State handle() {
        try {
            Calc calc = new CalcImpl();
            System.out.println("Result: " + calc.handle(userData));
        } finally {
            userData.clear();
        }

        if (files == null) {
            return new ReadDataFromCon(scanner);
        } else {
            return new ReadDataFromFiles(scanner, files.get(0), files.get(1));
        }

    }

    @Override
    public StateType getType() {
        return CALC;
    }
}
