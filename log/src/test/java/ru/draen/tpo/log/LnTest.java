package ru.draen.tpo.log;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LnTest extends AbstractAppFunctionTest {
    @Override
    protected AppFunction getAppFunction() {
        return new Ln();
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out/ln.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/ln.csv")
    @DisplayName("ln(x) test")
    void lnTest(double x, double expected) {
        doTest(x, expected);
    }
}
