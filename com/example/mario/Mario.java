// I control zero internet domains, so this is as proper as it’s
// going to get.
package com.example.mario;

import java.lang.String;
import java.lang.Integer;
import java.io.Console;
import java.io.IOException;

class Mario {

    public static void main(String[] args) {
        Printer out = null;
        boolean toFile = getBool("Output to file (yes/no)? ");
        if (toFile) {
            System.out.print("File name? ");
            Console c = System.console();
            String file = c.readLine();
            out = new FilePrinter(file);
        }
        else {
            out = new StdoutPrinter();
        }
        int h = getInt(
                String.format("Height (0–%d)? ", Pyramid.maxHeight),
                0, Pyramid.maxHeight
        );
        try{
            out.print(PyramidFactory.pyramid(h));
        } catch (InvalidHeightException e) {
            e.printStackTrace();
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
