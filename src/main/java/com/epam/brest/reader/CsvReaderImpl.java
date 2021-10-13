package com.epam.brest.reader;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvReaderImpl implements Reader {

    @Override
    public BigDecimal getValueFromFile(BigDecimal value, String filePath) {

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            BigDecimal bigDecimalPrice = BigDecimal.ZERO;
            BigDecimal bigDecimalRange;
            List<String> priceList = stream
                    .skip(1)
                    .collect(Collectors.toList());
            for (String line : priceList) {
                String[] pricePerRange = line.split(",");
                String range = pricePerRange[0];
                String price = pricePerRange[1];
                bigDecimalPrice = new BigDecimal(price);
                bigDecimalRange = new BigDecimal(range);
                if(bigDecimalRange.compareTo(value) >= 0) {
                    return bigDecimalPrice;
                }
            }
            return bigDecimalPrice;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
