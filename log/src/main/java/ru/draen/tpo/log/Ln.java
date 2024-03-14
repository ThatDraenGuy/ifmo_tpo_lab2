package ru.draen.tpo.log;

import ru.draen.tpo.core.AppFunction;

public class Ln implements AppFunction {

    @Override
    public double calculate(double x, double eps) {
        double constant = ((x - 1) * (x - 1)) / ((x + 1) * (x + 1));

        double sum = 0;
        double current = (x - 1) / (x + 1);
        int iteration = 1;

        do {
            sum += current;
            current = (2 * iteration - 1) * current * constant / (2 * current + 1);
            iteration++;
        } while (Math.abs(current) > eps / 2);
        return sum * 2;
    }

}
