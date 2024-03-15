package ru.draen.tpo.app;

import ru.draen.tpo.core.AppFunction;

public class AppExpression implements AppFunction {
    private final TrigExpression trig;
    private final LogExpression log;

    public AppExpression() {
        this.trig = new TrigExpression();
        this.log = new LogExpression();
    }

    public AppExpression(TrigExpression trig, LogExpression log) {
        this.trig = trig;
        this.log = log;
    }

    @Override
    public double calculate(double x, double eps) {
        return x > 0 ? trig.calculate(x, eps) : log.calculate(x, eps);
    }

}
