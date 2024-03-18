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
public class CotMockedTest extends AbstractAppFunctionTest {
    private final Cos mockedCos = mock(Cos.class);
    private final Sin mockedSin = mock(Sin.class);

    {
        fillMock(mockedCos, "src/test/resources/mock/cos.csv");
        fillMock(mockedSin, "src/test/resources/mock/sin.csv");
    }


    @Override
    protected AppFunction getAppFunction() {
        return new Cot(mockedSin, mockedCos);
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out_mocked/cot.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/cot.csv")
    @DisplayName("cot(x) mocked test")
    void cosTest(double x, double expected) {
        doTest(x, expected);
    }
}
