package ru.draen.tpo.trig;

public class Cos extends TrigFunction {

    @Override
    public double calculate(double x, double eps) {
        x = resolveX(x);

        int iteration = 0;
        double result = 0;

        double term;
        do {
            term = getTerm(x, iteration++);
            result += iteration % 2 == 0 ? term : -term;
        } while (term > eps);

        return result;
    }

    private double getTerm(double x, int k) {
        return Math.pow(x, 2 * k) / getFactorial(2 * k);
    }

    private double getFactorial(double num) {
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
