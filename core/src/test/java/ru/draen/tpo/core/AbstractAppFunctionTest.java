package ru.draen.tpo.core;

import org.junit.jupiter.api.BeforeAll;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractAppFunctionTest {
    protected abstract AppFunction getAppFunction();

    protected abstract String getLogPath();

    private FunctionLogger logger;

    @BeforeAll
    void setup() {
        try {
            File file = new File(getLogPath());
            file.createNewFile();
            logger = new CsvLogger(getLogPath());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    protected void doTest(double x, double expected) {
        doTest(x, expected, false);
    }

    protected void doTest(double x, double expected, boolean doRelative) {
        AppFunction func = getAppFunction();
        for (double eps = 0.1; eps >= 0.0001; eps /= 10) {
            if (Double.isNaN(expected)) {
                double finalEps = eps;
                assertThrows(IllegalArgumentException.class, () -> {
                    func.calculate(x, finalEps, logger);
                });
            } else {
                double res = func.calculate(x, eps, logger);
                double delta = doRelative ? Math.abs(eps * expected) : eps;
                assertEquals(expected, res, delta);
            }
        }
    }
}
