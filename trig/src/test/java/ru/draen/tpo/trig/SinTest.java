package ru.draen.tpo.trig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SinTest extends AbstractAppFunctionTest {
    @Override
    protected AppFunction getAppFunction() {
        return new Sin();
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out/sin.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/sin.csv")
    @DisplayName("sin(x) test")
    void sinTest(double x, double expected) {
        doTest(x, expected);
    }
}
