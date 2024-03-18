package ru.draen.tpo.trig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TanTest extends AbstractAppFunctionTest {
    @Override
    protected AppFunction getAppFunction() {
        return new Tan();
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out/tan.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/tan.csv")
    @DisplayName("tan(x) test")
    void tanTest(double x, double expected) {
        doTest(x, expected);
    }
}
