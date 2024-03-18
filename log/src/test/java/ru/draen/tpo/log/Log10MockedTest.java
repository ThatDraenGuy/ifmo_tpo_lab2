package ru.draen.tpo.log;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;

import static org.mockito.Mockito.mock;
import static ru.draen.tpo.core.FillMock.fillMock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Log10MockedTest extends AbstractAppFunctionTest {
    private final Ln mockedLn = mock(Ln.class);

    {
        fillMock(mockedLn, "src/test/resources/mock/ln.csv");
    }

    @Override
    protected AppFunction getAppFunction() {
        return new Log10(mockedLn);
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out_mocked/log5.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/log10.csv")
    @DisplayName("log10(x) mocked test")
    void lnTest(double x, double expected) {
        doTest(x, expected);
    }
}
