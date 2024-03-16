package ru.draen.tpo.trig;

import ru.draen.tpo.core.AppFunction;

public class Csc implements AppFunction {
    private final Sin sin = new Sin();

    @Override
    public double calculate(double x, double eps) {
        if (Math.abs(x % Math.PI) < eps) {
            throw new IllegalArgumentException();
        }

        return 1.0 / sin.calculate(x, eps);
    }

}
