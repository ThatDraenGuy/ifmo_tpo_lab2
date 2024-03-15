package ru.draen.tpo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import ru.draen.tpo.core.AppFunction;
import ru.draen.tpo.core.CsvLogger;
import ru.draen.tpo.core.FunctionLogger;
import ru.draen.tpo.log.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogIntegrationTest {
    private final static String LOG_PATH = "src/test/resources/out/log.csv";

    private FunctionLogger logger;
    private Log3 log3 = mock(Log3.class);
    private Log5 log5 = mock(Log5.class);
    private Log10 log10 = mock(Log10.class);

    @BeforeAll
    void setup() {
        try {
            File file = new File(LOG_PATH);
            file.createNewFile();
            logger = new CsvLogger(LOG_PATH);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        fillMock(log3, "src/test/resources/mock/log3.csv");
        fillMock(log5, "src/test/resources/mock/log5.csv");
        fillMock(log10, "src/test/resources/mock/log10.csv");
    }

    private void fillMock(AppFunction function, String dataPath) {
        try (CSVReader reader = new CSVReader(new FileReader(dataPath))) {
            List<String[]> data = reader.readAll();

            for (String[] values : data) {
                double x = Double.parseDouble(values[0]);
                double y = Double.parseDouble(values[1]);
                when(function.calculate(eq(x), anyDouble())).thenReturn(y);
            }

        } catch (IOException | CsvException ignored) {
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/log.csv")
    @DisplayName("log test")
    void logTest(double x, double expected) {
        LogExpression log = new LogExpression(log3, log5, log10);
        for (double eps = 0.1; eps >= 0.0001; eps /= 10) {
            double res = log.calculate(x, eps, logger);
            assertEquals(expected, res, eps);
        }
    }
}
