package ru.draen.tpo.trig;

import ru.draen.tpo.core.AppFunction;

public class Csc implements AppFunction {
    private final Sin sin = new Sin();

    @Override
    public double calculate(double x, double eps) {
        double sin = this.sin.calculate(x, eps);

        if (Math.abs(sin) < 0.001) {
            return Double.POSITIVE_INFINITY;
        }

        return 1.0 / sin;
    }

}
