package com.epam.brest.reader;

import java.math.BigDecimal;

public interface Reader {

       BigDecimal readPrices (BigDecimal value, String filePath);
}
