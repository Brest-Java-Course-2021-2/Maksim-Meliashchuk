package com.epam.brest.calc;

import java.math.BigDecimal;
import java.util.List;

public class CalcImpl implements Calc {

    @Override
    public BigDecimal handle(List<BigDecimal> userData) {
        return userData.get(0).multiply(userData.get(1)).add(userData.get(2).multiply(userData.get(3)));
    }
}