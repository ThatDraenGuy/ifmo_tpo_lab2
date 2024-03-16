package ru.draen.tpo.trig;

import ru.draen.tpo.core.AppFunction;

public class Sec implements AppFunction {
    private final Cos cos = new Cos();

    @Override
    public double calculate(double x, double eps) {
        if (Math.abs((x - Math.PI / 2) % Math.PI) < eps) {
            throw new IllegalArgumentException();
        }

        return 1.0 / cos.calculate(x, eps);
    }

}
