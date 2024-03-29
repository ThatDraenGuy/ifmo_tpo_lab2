package ru.draen.tpo.log;

public class Ln extends AbstractLogFunction {

    @Override
    public double calculate(double x, double eps) {
        checkX(x, eps);

        double constant = ((x - 1) * (x - 1)) / ((x + 1) * (x + 1));

        double sum = 0;
        double current = (x - 1) / (x + 1);
        int iteration = 1;

        while (Math.abs(current) > eps / 8) {
            sum += current;
            current = (2 * iteration - 1) * current * constant / (2 * iteration + 1);
            iteration++;
        }
        return sum * 2;
    }

}
