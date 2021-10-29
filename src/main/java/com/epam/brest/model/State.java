package com.epam.brest.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public interface State {

    List<String> messagesForReadFromFile = new ArrayList<>(Arrays.asList("Please enter weight:",
            "Please enter distance:"));
    List<String> messagesForConInput = new ArrayList<>(Arrays.asList("Please enter weight:",
            "Enter pricePerKg:", "Please enter distance:", "Enter pricePerKm:"));
    List<BigDecimal> userData = new ArrayList<>();
    String COMMAND_TO_EXIT = "q";

    State handle();

    StateType getType();
}
