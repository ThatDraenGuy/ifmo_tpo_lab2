package ru.draen.tpo.log;

public class Log10 extends AbstractLogFunction {
    private final Ln ln;
    private final static double LN10 = 2.30258509299;

    public Log10() {
        this.ln = new Ln();
    }

    public Log10(Ln ln) {
        this.ln = ln;
    }

    @Override
    public double calculate(double x, double eps) {
        checkX(x, eps);
        return ln.calculate(x, eps) / LN10;
    }

}
