package ru.draen.tpo.trig;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class CotTest {
    private FunctionLogger logger;
    private final static String LOG_PATH = "src/test/resources/out/cot.csv";

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
    @CsvFileSource(resources = "/in/cot.csv")
    @DisplayName("cot(x) test")
    void cotTest(double x, double expected) {
        Cot cot = new Cot();
        for (double eps = 0.1; eps >= 0.0001; eps /= 10) {
            double res = cot.calculate(x, eps, logger);
            assertEquals(expected, res, eps);
        }
    }

}
