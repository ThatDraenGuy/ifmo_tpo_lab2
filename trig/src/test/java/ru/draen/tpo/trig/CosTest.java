package ru.draen.tpo.trig;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CosTest extends AbstractAppFunctionTest {
    @Override
    protected AppFunction getAppFunction() {
        return new Cos();
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out/cos.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/cos.csv")
    @DisplayName("cos(x) test")
    void cosTest(double x, double expected) {
        doTest(x, expected);
    }
}
