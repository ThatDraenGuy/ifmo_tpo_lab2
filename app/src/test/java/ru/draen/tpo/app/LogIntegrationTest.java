package ru.draen.tpo.app;

import static org.mockito.Mockito.mock;
import static ru.draen.tpo.core.FillMock.fillMock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;
import ru.draen.tpo.log.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogIntegrationTest extends AbstractAppFunctionTest {
    private final Log3 log3 = mock(Log3.class);
    private final Log5 log5 = mock(Log5.class);
    private final Log10 log10 = mock(Log10.class);

    {
        fillMock(log3, "src/test/resources/mock/log3.csv");
        fillMock(log5, "src/test/resources/mock/log5.csv");
        fillMock(log10, "src/test/resources/mock/log10.csv");
    }

    @Override
    protected AppFunction getAppFunction() {
        return new LogExpression(log3, log5, log10);
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out_mocked/log.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/log.csv")
    @DisplayName("log test")
    void logTest(double x, double expected) {
        doTest(x, expected);
    }
}
