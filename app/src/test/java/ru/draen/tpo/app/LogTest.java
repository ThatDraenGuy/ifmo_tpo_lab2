package ru.draen.tpo.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogTest extends AbstractAppFunctionTest {
    @Override
    protected AppFunction getAppFunction() {
        return new LogExpression();
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out/log.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/log.csv")
    @DisplayName("log(x) test")
    void logTest(double x, double expected) {
        doTest(x, expected, true);
    }
}
