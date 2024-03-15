package ru.draen.tpo.trig;

import ru.draen.tpo.core.AppFunction;

public class Tan implements AppFunction {

    private final Sin sin = new Sin();
    private final Cos cos = new Cos();

    @Override
    public double calculate(double x, double eps) {

        double sin = this.sin.calculate(x, eps);
        double cos = this.cos.calculate(x, eps);

        if (Math.abs(cos) < 0.001 && sin > 0) {
            return Double.POSITIVE_INFINITY;
        } else if (Math.abs(cos) < 0.001 && sin < 0) {
            return Double.NEGATIVE_INFINITY;
        }

        return sin / cos;
    }
}
