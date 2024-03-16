package ru.draen.tpo.trig;

import ru.draen.tpo.core.AbstractAppFunction;

public class Csc extends AbstractAppFunction {
    private final Sin sin = new Sin();

    @Override
    public double calculate(double x, double eps) {
        checkX(x, eps);

        return 1.0 / sin.calculate(x, eps / 20);
    }

    @Override
    public boolean validateDomain(double x, double eps) {
        return Math.abs(x % Math.PI) != 0;
    }
}
