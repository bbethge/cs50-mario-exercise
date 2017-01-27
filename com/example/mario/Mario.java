// I control zero internet domains, so this is as proper as it’s
// going to get.
package com.example.mario;

import java.lang.String;
import java.lang.Integer;
import java.io.Console;
import java.io.IOException;
import java.io.Writer;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

class Mario {
    public static void main(String[] args) {
        Writer writer = null;
        boolean toFile = getBool("Output to file (yes/no)? ");
        if (toFile) {
            do {
                System.out.print("File name? ");
                Console c = System.console();
                String file = c.readLine();
                try {
                    writer = new FileWriter(file);
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            while (writer == null);
        }
        else {
            writer = new OutputStreamWriter(System.out);
        }
        int h = getInt("Height (0–23)? ", 0, 23);
        try {
            for (int w = 2; w <= h+1; w++) {
                for (int i = 0; i < h+1-w; i++) {
                    writer.write(" ");
                }
                for (int i = 0; i < w; i++) {
                    writer.write("#");
                }
                writer.write(System.lineSeparator());
            }
            writer.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (toFile) {
            try {
                writer.close();
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static boolean getBool(String prompt) {
        Console c = System.console();
        boolean valid = false;
        boolean ret = false;
        while (!valid) {
            System.out.print(prompt);
            String boolStr = c.readLine().toLowerCase();
            if (boolStr.equals("y") || boolStr.equals("yes")) {
                ret = true;
                valid = true;
            }
            else if (boolStr.equals("n") || boolStr.equals("no")) {
                valid = true;
            }
        }
        return ret;
    }

    private static int getInt(String prompt, int min, int max) {
        Console c = System.console();
        boolean valid;
        int ret = min;
        do {
            System.out.print(prompt);
            String intStr = c.readLine();
            valid = true;
            try {
                ret = Integer.parseInt(intStr);
            }
            catch (NumberFormatException e) {
                valid = false;
            }
        }
        while ((!valid) || ret < min || ret > max);
        return ret;
    }
}
