package com.epam.brest.model;

import static com.epam.brest.model.StatesType.EXIT;

public class Exit implements State{
    @Override
    public State handle() {
        return null;
    }

    @Override
    public StatesType getType() {
        return EXIT;
    }
}
