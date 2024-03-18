package ru.draen.tpo.trig;

import ru.draen.tpo.core.AppFunction;

public class Sin implements AppFunction {
    private final Cos cos;

    public Sin() {
        cos = new Cos();
    }

    public Sin(Cos cos) {
        this.cos = cos;
    }

    @Override
    public double calculate(double x, double eps) {
        int sign = Math.abs(x) % (Math.PI * 2) <= Math.PI ? 1 : -1;
        sign = x >= 0 ? sign : -sign;
        return sign * Math.sqrt(1 - Math.pow(cos.calculate(x, eps), 2));
    }

}
