package ru.draen.tpo.trig;

public class Tan extends TrigFunction {

    private final Sin sin = new Sin();
    private final Cos cos = new Cos();

    @Override
    public double calculate(double x, double eps) {
        return sin.calculate(x, eps) / cos.calculate(x, eps);
    }

}
