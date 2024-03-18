package ru.draen.tpo.trig;

import static org.mockito.Mockito.mock;
import static ru.draen.tpo.core.FillMock.fillMock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SinMockedTest extends AbstractAppFunctionTest {
    private final Cos mockedCos = mock(Cos.class);

    {
        fillMock(mockedCos, "src/test/resources/mock/cos.csv");
    }

    @Override
    protected AppFunction getAppFunction() {
        return new Sin(mockedCos);
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out_mocked/sin.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/sin.csv")
    @DisplayName("sin(x) mocked test")
    void sinTest(double x, double expected) {
        doTest(x, expected);
    }
}
