package ru.draen.tpo.app;

import ru.draen.tpo.core.AppFunction;
import ru.draen.tpo.log.LogExpression;
import ru.draen.tpo.trig.TrigExpression;

public class AppExpression implements AppFunction {
    private final TrigExpression trig = new TrigExpression();
    private final LogExpression log = new LogExpression();

    @Override
    public double calculate(double x, double eps) {
        return x > 0 ? trig.calculate(x, eps) : log.calculate(x, eps);
    }

}
