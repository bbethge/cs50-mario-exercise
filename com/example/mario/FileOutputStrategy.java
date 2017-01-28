package com.example.mario;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputStrategy implements OutputStrategy {

    private FileWriter out;

    public FileOutputStrategy(String fileName) throws IOException {
        out = new FileWriter(fileName);
    }

    public void print(String s) throws IOException {
        out.write(s);
    }

    public void close() throws IOException {
        out.close();
    }

}
