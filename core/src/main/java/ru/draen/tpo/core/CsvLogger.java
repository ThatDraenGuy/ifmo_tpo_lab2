package ru.draen.tpo.core;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class CsvLogger implements FunctionLogger {

    private final CSVWriter writer;

    public CsvLogger(String fileName) throws IOException {
        writer = new CSVWriter(new FileWriter(fileName));
    }

    @Override
    public void log(double x, double eps, double result) {
        writer.writeNext(new String[] { Double.toString(x), Double.toString(eps), Double.toString(result) });
    }

}
