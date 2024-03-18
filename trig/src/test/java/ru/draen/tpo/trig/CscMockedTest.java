package ru.draen.tpo.trig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;

import static org.mockito.Mockito.mock;
import static ru.draen.tpo.core.FillMock.fillMock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CscMockedTest extends AbstractAppFunctionTest {
    private final Sin mockedSin = mock(Sin.class);

    {
        fillMock(mockedSin, "src/test/resources/mock/sin.csv");
    }


    @Override
    protected AppFunction getAppFunction() {
        return new Csc(mockedSin);
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out_mocked/csc.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/csc.csv")
    @DisplayName("csc(x) mocked test")
    void cosTest(double x, double expected) {
        doTest(x, expected);
    }
}
