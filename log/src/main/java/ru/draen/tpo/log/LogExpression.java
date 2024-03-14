package ru.draen.tpo.log;

import ru.draen.tpo.core.AppFunction;
import static java.lang.Math.pow;

public class LogExpression implements AppFunction {

    private final Log3 log3 = new Log3();
    private final Log5 log5 = new Log5();
    private final Log10 log10 = new Log10();

    @Override
    public double calculate(double x, double eps) {
        double log3 = this.log3.calculate(x, eps);
        double log5 = this.log5.calculate(x, eps);
        double log10 = this.log10.calculate(x, eps);

        return pow((pow((log5 / log3), 3) + log3), 3) + log10;
    }

}
