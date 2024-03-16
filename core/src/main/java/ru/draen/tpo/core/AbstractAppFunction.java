package ru.draen.tpo.core;

public abstract class AbstractAppFunction implements AppFunction {

    protected void checkX(double x, double eps) {
        if (!validateDomain(x, eps)) {
            throw new IllegalArgumentException("X is out of domain");
        }
    }
}
