package ru.draen.tpo.app;

import ru.draen.tpo.core.AppFunction;
import ru.draen.tpo.log.Log10;
import ru.draen.tpo.log.Log3;
import ru.draen.tpo.log.Log5;

import static java.lang.Math.pow;

public class LogExpression implements AppFunction {
    private final Log3 log3;
    private final Log5 log5;
    private final Log10 log10;

    public LogExpression() {
        this.log3 = new Log3();
        this.log5 = new Log5();
        this.log10 = new Log10();
    }

    public LogExpression(Log3 log3, Log5 log5, Log10 log10) {
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }

    @Override
    public double calculate(double x, double eps) {
        double log3 = this.log3.calculate(x, eps);
        double log5 = this.log5.calculate(x, eps);
        double log10 = this.log10.calculate(x, eps);

        return pow((pow((log5 / log3), 3) + log3), 3) + log10;
    }

}
