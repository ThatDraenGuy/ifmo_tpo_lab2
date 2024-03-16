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
public class Log5Test extends AbstractAppFunctionTest {
    @Override
    protected AppFunction getAppFunction() {
        return new Log5();
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out/log5.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/log5.csv")
    @DisplayName("log5(x) test")
    void log5Test(double x, double expected) {
        doTest(x, expected);
    }
}
