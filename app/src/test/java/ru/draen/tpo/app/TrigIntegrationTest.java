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
import ru.draen.tpo.trig.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TrigIntegrationTest {
    private final static String LOG_PATH = "src/test/resources/out/trig.csv";

    private FunctionLogger logger;
    private Sin sin = mock(Sin.class);
    private Cos cos = mock(Cos.class);
    private Tan tan = mock(Tan.class);
    private Cot cot = mock(Cot.class);
    private Csc csc = mock(Csc.class);
    private Sec sec = mock(Sec.class);

    @BeforeAll
    void setup() {
        try {
            File file = new File(LOG_PATH);
            file.createNewFile();
            logger = new CsvLogger(LOG_PATH);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        fillMock(sin, "src/test/resources/mock/sin.csv");
        fillMock(cos, "src/test/resources/mock/cos.csv");
        fillMock(tan, "src/test/resources/mock/tan.csv");
        fillMock(cot, "src/test/resources/mock/cot.csv");
        fillMock(csc, "src/test/resources/mock/csc.csv");
        fillMock(sec, "src/test/resources/mock/sec.csv");
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
    @CsvFileSource(resources = "/in/trig.csv")
    @DisplayName("trig test")
    void trigTest(double x, double expected) {
        TrigExpression trig = new TrigExpression(sin, cos, tan, cot, csc, sec);
        for (double eps = 0.1; eps >= 0.0001; eps /= 10) {
            double res = trig.calculate(x, eps, logger);
            assertEquals(expected, res, eps);
        }
    }
}
