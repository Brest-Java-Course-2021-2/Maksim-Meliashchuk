package com.epam.brest.model;

import static com.epam.brest.model.StateType.EXIT;

public class Exit implements State{
    @Override
    public State handle() {
        return null;
    }

    @Override
    public StateType getType() {
        return EXIT;
    }
}
