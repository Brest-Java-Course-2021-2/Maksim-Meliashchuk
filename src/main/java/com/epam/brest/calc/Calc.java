package com.epam.brest.calc;

import java.math.BigDecimal;
import java.util.List;

public interface Calc {

    BigDecimal handle(List<BigDecimal> userData);

}