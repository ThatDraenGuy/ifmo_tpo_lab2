package ru.draen.tpo.trig;

import ru.draen.tpo.core.AbstractAppFunction;

public class Sec extends AbstractAppFunction {
    private final Cos cos;

    public Sec() {
        cos = new Cos();
    }

    public Sec(Cos cos) {
        this.cos = cos;
    }

    @Override
    public double calculate(double x, double eps) {
        checkX(x, eps);

        return 1.0 / cos.calculate(x, eps / 20);
    }

    @Override
    public boolean validateDomain(double x, double eps) {
        return Math.abs((x - Math.PI / 2) % Math.PI) != 0;
    }
}
