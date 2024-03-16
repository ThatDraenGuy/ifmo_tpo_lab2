package ru.draen.tpo.app;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import ru.draen.tpo.core.AppFunction;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class FillMock {
    public static void fillMock(AppFunction function, String dataPath) {
        try (CSVReader reader = new CSVReader(new FileReader(dataPath))) {
            List<String[]> data = reader.readAll();

            when(function.validateDomain(anyDouble(), anyDouble())).thenReturn(false);

            for (String[] values : data) {
                double x = Double.parseDouble(values[0]);
                double y = Double.parseDouble(values[1]);
                when(function.calculate(eq(x), anyDouble())).thenReturn(y);
                when(function.validateDomain(eq(x), anyDouble())).thenReturn(!Double.isNaN(y));
            }

        } catch (IOException | CsvException ignored) {
        }
    }
}
