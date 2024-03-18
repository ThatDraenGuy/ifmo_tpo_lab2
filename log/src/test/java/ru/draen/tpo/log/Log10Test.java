package ru.draen.tpo.log;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Log10Test extends AbstractAppFunctionTest {
    @Override
    protected AppFunction getAppFunction() {
        return new Log10();
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out/log10.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/log10.csv")
    @DisplayName("log10(x) test")
    void log10Test(double x, double expected) {
        doTest(x, expected);
    }

}
