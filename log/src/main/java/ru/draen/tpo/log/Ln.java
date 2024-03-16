package ru.draen.tpo.log;

public class Ln extends LogFunction {

    @Override
    public double calculate(double x, double eps) {
        validateDomain(x);

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
