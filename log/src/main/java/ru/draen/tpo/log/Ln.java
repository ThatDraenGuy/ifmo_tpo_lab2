package ru.draen.tpo.log;

import ru.draen.tpo.core.AppFunction;

public class Ln implements AppFunction {

    @Override
    public double calculate(double x, double eps) {
        if (Math.abs(x) < 0.0001) {
            return Double.NEGATIVE_INFINITY;
        }

        double constant = ((x - 1) * (x - 1)) / ((x + 1) * (x + 1));

        double sum = 0;
        double current = (x - 1) / (x + 1);
        int iteration = 1;

        while (Math.abs(current) > eps / 4) {
            sum += current;
            current = (2 * iteration - 1) * current * constant / (2 * iteration + 1);
            iteration++;
        }
        return sum * 2;
    }

}
