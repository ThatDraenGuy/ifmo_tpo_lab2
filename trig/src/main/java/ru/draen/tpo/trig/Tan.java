package ru.draen.tpo.trig;

import ru.draen.tpo.core.AppFunction;

public class Tan implements AppFunction {

    private final Sin sin = new Sin();
    private final Cos cos = new Cos();

    @Override
    public double calculate(double x, double eps) {
        if (Math.abs((x - Math.PI / 2) % Math.PI) < eps) {
            throw new IllegalArgumentException();
        }

        return sin.calculate(x, eps) / cos.calculate(x, eps);
    }
}
