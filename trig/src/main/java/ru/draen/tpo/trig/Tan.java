package ru.draen.tpo.trig;

import ru.draen.tpo.core.AbstractAppFunction;

public class Tan extends AbstractAppFunction {

    private final Sin sin = new Sin();
    private final Cos cos = new Cos();

    @Override
    public double calculate(double x, double eps) {
        checkX(x, eps);

        return sin.calculate(x, eps / 10) / cos.calculate(x, eps / 10);
    }

    @Override
    public boolean validateDomain(double x, double eps) {
        return Math.abs((x - Math.PI / 2) % Math.PI) != 0;
    }
}
