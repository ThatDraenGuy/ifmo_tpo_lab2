package ru.draen.tpo.trig;

import ru.draen.tpo.core.AbstractAppFunction;

public class Tan extends AbstractAppFunction {

    private final Sin sin;
    private final Cos cos;

    public Tan() {
        sin = new Sin();
        cos = new Cos();
    }

    public Tan(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    @Override
    public double calculate(double x, double eps) {
        checkX(x, eps);

        return sin.calculate(x, eps / 20) / cos.calculate(x, eps / 20);
    }

    @Override
    public boolean validateDomain(double x, double eps) {
        return Math.abs((x - Math.PI / 2) % Math.PI) != 0;
    }
}
