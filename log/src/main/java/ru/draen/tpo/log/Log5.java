package ru.draen.tpo.log;

public class Log5 extends AbstractLogFunction {
    private final Ln ln;
    private static final double LN5 = 1.60943791243;

    public Log5() {
        this.ln = new Ln();
    }

    public Log5(Ln ln) {
        this.ln = ln;
    }

    @Override
    public double calculate(double x, double eps) {
        checkX(x, eps);
        return ln.calculate(x, eps) / LN5;
    }
}
