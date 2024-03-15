package ru.draen.tpo.trig;

import ru.draen.tpo.core.AppFunction;

public class Cos implements AppFunction {

    @Override
    public double calculate(double x, double eps) {
        x = Math.abs(x);

        x = x % (2 * Math.PI); // 0 <= x <= 2*PI
        if (x > Math.PI) {
            x = Math.PI * 2 - x;
        }

        boolean isNegative = false;
        if (x > Math.PI / 2) {
            x = Math.PI - x;
            isNegative = !isNegative;
        }

        int iteration = 0;
        double result = 0;

        double term;
        do {
            term = getTerm(x, iteration);
            result += iteration % 2 == 0 ? term : -term;
            iteration++;
        } while (term >= eps);

        return isNegative ? -result : result;
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
