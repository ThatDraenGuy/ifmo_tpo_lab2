package ru.draen.tpo.trig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CotTest extends AbstractAppFunctionTest {
    @Override
    protected AppFunction getAppFunction() {
        return new Cot();
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out/cot.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/cot.csv")
    @DisplayName("cot(x) test")
    void cotTest(double x, double expected) {
        doTest(x, expected);
    }
}
