package ru.draen.tpo.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AppTest extends AbstractAppFunctionTest {
    @Override
    protected AppFunction getAppFunction() {
        return new AppExpression();
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out/app.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/app.csv")
    @DisplayName("app(x) test")
    void cosTest(double x, double expected) {
        doTest(x, expected);
    }
}
