package ru.draen.tpo.log;

public class Log3 extends AbstractLogFunction {
    private final Ln ln;
    private static final double LN3 = 1.09861228867;

    public Log3() {
        this.ln = new Ln();
    }

    public Log3(Ln ln) {
        this.ln = ln;
    }

    @Override
    public double calculate(double x, double eps) {
        return ln.calculate(x, eps) / LN3;
    }

}
