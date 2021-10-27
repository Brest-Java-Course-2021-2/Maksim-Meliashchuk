package com.epam.brest.calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalcImplTest {
    Calc calc = new CalcImpl();

    @Test
    void testHandleMethod() {

        List<BigDecimal> userData = new ArrayList<>();

        userData.add(new BigDecimal("10"));
        userData.add(new BigDecimal("10"));
        userData.add(new BigDecimal("10"));
        userData.add(new BigDecimal("10"));
        assertNotNull(calc);
        assertEquals(new BigDecimal("200") , calc.handle(userData));
    }

    @Test()
    void testHandleMethodWithNullParameters() {
        List<BigDecimal> userData = new ArrayList<>();
        userData.add(null);
        userData.add(null);
        userData.add(null);
        userData.add(null);
        assertNotNull(calc);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calc.handle(userData);
        });
    }

}