package ru.draen.tpo.log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import ru.draen.tpo.core.AbstractAppFunctionTest;
import ru.draen.tpo.core.AppFunction;
import ru.draen.tpo.core.CsvLogger;
import ru.draen.tpo.core.FunctionLogger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Log3Test extends AbstractAppFunctionTest {
    @Override
    protected AppFunction getAppFunction() {
        return new Log3();
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out/log3.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/log3.csv")
    @DisplayName("log3(x) test")
    void log3Test(double x, double expected) {
        doTest(x, expected);
    }

}
