package com.epam.brest.reader;

import java.math.BigDecimal;

public interface Reader {

       BigDecimal getValueFromFile(BigDecimal value, String filePath);
}
