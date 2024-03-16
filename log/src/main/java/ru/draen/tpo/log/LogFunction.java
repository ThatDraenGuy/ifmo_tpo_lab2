package ru.draen.tpo.log;

import ru.draen.tpo.core.AppFunction;

public abstract class LogFunction implements AppFunction {
    protected void validateDomain(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("x has to be bigger than 0!");
        }
    }

}
