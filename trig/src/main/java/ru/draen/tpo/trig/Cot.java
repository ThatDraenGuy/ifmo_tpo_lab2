package ru.draen.tpo.trig;

import ru.draen.tpo.core.AppFunction;

public class Cot implements AppFunction {

    private final Sin sin = new Sin();
    private final Cos cos = new Cos();

    @Override
    public double calculate(double x, double eps) {
        if (Math.abs(x % Math.PI) < eps) {
            throw new IllegalArgumentException();
        }

        return cos.calculate(x, eps) / sin.calculate(x, eps);
    }

}
