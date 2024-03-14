package ru.draen.tpo.core;

public interface AppFunction {
    double calculate(double x, double eps);

    default double calculate(double x, double eps, FunctionLogger logger) {
        double res = calculate(x, eps);
        logger.log(x, eps, res);
        return res;
    }
}
