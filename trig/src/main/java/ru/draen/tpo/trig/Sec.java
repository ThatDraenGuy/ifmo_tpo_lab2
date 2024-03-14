package ru.draen.tpo.trig;

public class Sec extends TrigFunction {
    private final Cos cos = new Cos();

    @Override
    public double calculate(double x, double eps) {
        return 1.0 / cos.calculate(x, eps);
    }

}
