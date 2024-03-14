package ru.draen.tpo.trig;

import ru.draen.tpo.core.AppFunction;

public abstract class TrigFunction implements AppFunction {
    protected double resolveX(double x) {
        return x % (2 * Math.PI);
    }
}
