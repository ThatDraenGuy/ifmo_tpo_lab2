package ru.draen.tpo.app;

import static org.mockito.Mockito.mock;
import static ru.draen.tpo.app.FillMock.fillMock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;
import ru.draen.tpo.trig.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TrigIntegrationTest extends AbstractAppFunctionTest {
    private final Sin sin = mock(Sin.class);
    private final Cos cos = mock(Cos.class);
    private final Tan tan = mock(Tan.class);
    private final Cot cot = mock(Cot.class);
    private final Csc csc = mock(Csc.class);
    private final Sec sec = mock(Sec.class);

    @Override
    protected AppFunction getAppFunction() {
        return new TrigExpression(sin, cos, tan, cot, csc, sec);
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out/trig.csv";
    }

    {
        fillMock(sin, "src/test/resources/mock/sin.csv");
        fillMock(cos, "src/test/resources/mock/cos.csv");
        fillMock(tan, "src/test/resources/mock/tan.csv");
        fillMock(cot, "src/test/resources/mock/cot.csv");
        fillMock(csc, "src/test/resources/mock/csc.csv");
        fillMock(sec, "src/test/resources/mock/sec.csv");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/trig.csv")
    @DisplayName("trig test")
    void trigTest(double x, double expected) {
        doTest(x, expected, true);
    }
}
