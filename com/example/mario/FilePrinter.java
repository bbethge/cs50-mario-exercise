package com.example.mario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printer {

    private File file;

    public FilePrinter(String fileName) {
        file = new File(fileName);
    }

    /* Note that this replaces the contents of the file each time
     * it is called!
     */
    public void print(Pyramid p) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) {
            out.write(p.toString());
        } catch (IOException e) {
            System.err.println("Couldn’t write to file: " + e.getMessage());
        }
    }

}
