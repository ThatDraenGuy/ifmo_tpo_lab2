package ru.draen.tpo.trig;

public class Cot extends TrigFunction {

    private final Tan tan = new Tan();

    @Override
    public double calculate(double x, double eps) {
        return 1.0 / tan.calculate(x, eps);
    }

}
