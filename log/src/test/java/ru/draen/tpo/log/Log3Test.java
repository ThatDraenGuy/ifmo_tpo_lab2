package ru.draen.tpo.log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.CsvLogger;
import ru.draen.tpo.core.FunctionLogger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Log3Test {
    private FunctionLogger logger;
    private final static String LOG_PATH = "src/test/resources/out/log3.csv";

    @BeforeAll
    void setup() {
        try {
            File file = new File(LOG_PATH);
            file.createNewFile();
            logger = new CsvLogger(LOG_PATH);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/log3.csv")
    @DisplayName("log3(x) test")
    void log3Test(double x, double expected) {
        Log3 log3 = new Log3();
        for (double eps = 0.1; eps >= 0.0001; eps /= 10) {
            double res = log3.calculate(x, eps, logger);
            assertEquals(expected, res, eps);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/log3_illegal.csv")
    @DisplayName("log3(x) illegal test")
    void log3IllegalTest(double x) {
        Log3 log3 = new Log3();
        assertThrows(IllegalArgumentException.class, () -> {
            log3.calculate(x, 0.1);
        });
    }

}
