package ru.draen.tpo.app;

import ru.draen.tpo.core.AbstractAppFunction;
import ru.draen.tpo.core.AppFunction;

public class AppExpression extends AbstractAppFunction {
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
        checkX(x, eps);
        return x <= 0 ? trig.calculate(x, eps) : log.calculate(x, eps);
    }

    @Override
    public boolean validateDomain(double x, double eps) {
        return x <= 0 ? trig.validateDomain(x, eps) : log.validateDomain(x, eps);
    }
}
