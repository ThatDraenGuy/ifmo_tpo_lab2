package ru.draen.tpo.app;

import static org.mockito.Mockito.mock;
import static ru.draen.tpo.app.FillMock.fillMock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;

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
