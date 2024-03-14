package ru.draen.tpo.core;

public class FunctionExecutor {
    private final FunctionLogger logger;

    public FunctionExecutor(FunctionLogger logger) {
        this.logger = logger;
    }

    public void execute(AppFunction function, double start, double step, int step_count, double eps) {
        for (double x = start; x < start + step * step_count; x += step) {
            function.calculate(x, eps, logger);
        }
    }
}
