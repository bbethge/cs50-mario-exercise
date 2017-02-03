package com.example.mario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputStrategy implements OutputStrategy {

    private File file;

    public FileOutputStrategy(String fileName) {
        file = new File(fileName);
    }

    /* Note that this replaces the contents of the file each time
     * it is called!
     */
    public void print(String s) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            out.write(s);
        } catch (IOException e) {
            System.err.println("Couldn’t write to file: " + e.getMessage());
        }
    }

}
