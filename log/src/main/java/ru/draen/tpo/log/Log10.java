package ru.draen.tpo.log;

import ru.draen.tpo.core.AppFunction;

public class Log10 implements AppFunction {
    private final Ln ln = new Ln();
    private final static double LN10 = 2.30258509299;

    @Override
    public double calculate(double x, double eps) {
        return ln.calculate(x, eps) / LN10;
    }

}
