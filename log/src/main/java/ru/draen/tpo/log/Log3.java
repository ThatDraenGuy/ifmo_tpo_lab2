package ru.draen.tpo.log;

import ru.draen.tpo.core.AppFunction;

public class Log3 extends AbstractLogFunction {
    private final Ln ln = new Ln();
    private static final double LN3 = 1.09861228867;

    @Override
    public double calculate(double x, double eps) {
        return ln.calculate(x, eps) / LN3;
    }

}
