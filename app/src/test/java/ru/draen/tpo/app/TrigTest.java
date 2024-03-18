package ru.draen.tpo.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TrigTest extends AbstractAppFunctionTest {
    @Override
    protected AppFunction getAppFunction() {
        return new TrigExpression();
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out/trig.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/trig.csv")
    @DisplayName("trig(x) test")
    void trigTest(double x, double expected) {
        doTest(x, expected, true);
    }
}
