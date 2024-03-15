package ru.draen.tpo.trig;

import ru.draen.tpo.core.AppFunction;

public class Sec implements AppFunction {
    private final Cos cos = new Cos();

    @Override
    public double calculate(double x, double eps) {
        double cos = this.cos.calculate(x, eps);

        if (Math.abs(cos) < 0.001) {
            return Double.POSITIVE_INFINITY;
        }

        return 1.0 / cos;
    }

}
