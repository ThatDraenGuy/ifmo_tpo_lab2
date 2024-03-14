package ru.draen.tpo.trig;

public class Sin extends TrigFunction {
    private final Cos cos = new Cos();

    @Override
    public double calculate(double x, double eps) {
        x = Math.PI / 2 - x;
        return cos.calculate(x, eps);
    }

}
