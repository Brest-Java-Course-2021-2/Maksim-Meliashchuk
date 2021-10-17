package com.epam.brest.model;

import com.epam.brest.calc.CalcImpl;
import com.epam.brest.calc.Calc;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.epam.brest.model.StatesType.CALC;

public class Calc implements State{
    Scanner scanner;
    com.epam.brest.calc.Calc calc = new CalcImpl();

    public Calc(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public State handle() {
        try {

            com.epam.brest.calc.Calc calc = new CalcImpl();
            System.out.println("Result:" + calc.handle(weight, pricePerKg, length, pricePerKm));
            System.out.println("Result: " + userData.get(0).multiply(BigDecimal.valueOf(1)).add(userData.get(1).multiply(BigDecimal.valueOf(1))));
        } finally {
            userData.clear();
        }

        return new ReadData(scanner);
    }

    @Override
    public StatesType getType() {
        return CALC;
    }
}
