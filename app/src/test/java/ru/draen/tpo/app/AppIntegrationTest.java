package ru.draen.tpo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static ru.draen.tpo.app.FillMock.fillMock;

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

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;
import ru.draen.tpo.core.CsvLogger;
import ru.draen.tpo.core.FunctionLogger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppIntegrationTest extends AbstractAppFunctionTest {
    private final TrigExpression trig = mock(TrigExpression.class);
    private final LogExpression log = mock(LogExpression.class);

    {
        fillMock(log, "src/test/resources/in/log.csv");
        fillMock(trig, "src/test/resources/in/trig.csv");
    }

    @Override
    protected AppFunction getAppFunction() {
        return new AppExpression(trig, log);
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out/app.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/app.csv")
    @DisplayName("app test")
    void logTest(double x, double expected) {
        doTest(x, expected, true);
    }
}
