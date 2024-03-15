package ru.draen.tpo.trig;

import ru.draen.tpo.core.AppFunction;

public class Sin implements AppFunction {
    private final Cos cos = new Cos();

    @Override
    public double calculate(double x, double eps) {
        x = Math.PI / 2 - x;
        return cos.calculate(x, eps);
    }

}
