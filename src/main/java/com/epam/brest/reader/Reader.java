package com.epam.brest.reader;

import java.math.BigDecimal;
import java.net.URL;

public interface Reader {

       BigDecimal getValueFromFile(BigDecimal value, String filePath);
}
