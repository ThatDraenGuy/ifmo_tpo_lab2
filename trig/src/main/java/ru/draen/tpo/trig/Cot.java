package ru.draen.tpo.trig;

import ru.draen.tpo.core.AppFunction;

public class Cot implements AppFunction {

    private final Sin sin = new Sin();
    private final Cos cos = new Cos();

    @Override
    public double calculate(double x, double eps) {

        double sin = this.sin.calculate(x, eps);
        double cos = this.cos.calculate(x, eps);

        if (Math.abs(sin) < 0.001 && cos > 0) {
            return Double.POSITIVE_INFINITY;
        } else if (Math.abs(sin) < 0.001 && cos < 0) {
            return Double.NEGATIVE_INFINITY;
        }

        return cos / sin;
    }

}
