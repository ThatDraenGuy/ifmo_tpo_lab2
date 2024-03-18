package ru.draen.tpo.log;

public class Log5 extends AbstractLogFunction {
    private final Ln ln = new Ln();
    private static final double LN5 = 1.60943791243;

    @Override
    public double calculate(double x, double eps) {
        return ln.calculate(x, eps) / LN5;
    }
}
