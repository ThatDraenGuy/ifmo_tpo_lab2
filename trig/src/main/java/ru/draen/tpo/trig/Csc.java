package ru.draen.tpo.trig;

public class Csc extends TrigFunction {
    private final Sin sin = new Sin();

    @Override
    public double calculate(double x, double eps) {
        return 1.0 / sin.calculate(x, eps);
    }

}
