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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppIntegrationTest {
    private final static String LOG_PATH = "src/test/resources/out/app.csv";

    private FunctionLogger logger;
    private TrigExpression trig = mock(TrigExpression.class);
    private LogExpression log = mock(LogExpression.class);

    @BeforeAll
    void setup() {
        try {
            File file = new File(LOG_PATH);
            file.createNewFile();
            logger = new CsvLogger(LOG_PATH);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        fillMock(trig, "src/test/resources/in/trig.csv");
        fillMock(log, "src/test/resources/in/log.csv");
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
    @CsvFileSource(resources = "/in/app.csv")
    @DisplayName("app test")
    void logTest(double x, double expected) {
        AppExpression app = new AppExpression(trig, log);
        for (double eps = 0.1; eps >= 0.0001; eps /= 10) {
            double res = app.calculate(x, eps, logger);
            assertEquals(expected, res, eps);
        }
    }
}
