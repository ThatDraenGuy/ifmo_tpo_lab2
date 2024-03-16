package ru.draen.tpo.trig;

import ru.draen.tpo.core.AbstractAppFunction;

public class Cot extends AbstractAppFunction {

    private final Sin sin = new Sin();
    private final Cos cos = new Cos();

    @Override
    public double calculate(double x, double eps) {
        checkX(x, eps);

        return cos.calculate(x, eps / 10) / sin.calculate(x, eps / 10);
    }

    @Override
    public boolean validateDomain(double x, double eps) {
        return Math.abs(x % Math.PI) != 0;
    }

}
