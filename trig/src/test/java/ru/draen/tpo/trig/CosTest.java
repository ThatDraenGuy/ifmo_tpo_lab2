package ru.draen.tpo.trig;

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

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CosTest {
    private FunctionLogger logger;
    private final static String LOG_PATH = "src/test/resources/out/cos.csv";

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
    @CsvFileSource(resources = "/in/cos.csv")
    @DisplayName("cos(x) test")
    void cosTest(double x, double expected) {
        Cos cos = new Cos();
        for (double eps = 0.1; eps >= 0.0001; eps /= 10) {
            double res = cos.calculate(x, eps, logger);
            assertEquals(expected, res, eps);
        }
    }

}
