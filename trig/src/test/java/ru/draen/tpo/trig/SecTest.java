package ru.draen.tpo.trig;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class SecTest extends AbstractAppFunctionTest {
    @Override
    protected AppFunction getAppFunction() {
        return new Sec();
    }

    @Override
    protected String getLogPath() {
        return "src/test/resources/out/sec.csv";
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/in/sec.csv")
    @DisplayName("sec(x) test")
    void secTest(double x, double expected) {
        doTest(x, expected);
    }

}
