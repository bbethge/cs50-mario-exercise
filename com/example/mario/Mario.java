// I control zero internet domains, so this is as proper as it’s
// going to get.
package com.example.mario;

import java.lang.String;
import java.lang.Integer;
import java.io.Console;
import java.io.IOException;

class Mario {

    public static void main(String[] args) {
        OutputStrategy out = null;
        boolean toFile = getBool("Output to file (yes/no)? ");
        if (toFile) {
            System.out.print("File name? ");
            Console c = System.console();
            String file = c.readLine();
            out = new FileOutputStrategy(file);
        }
        else {
            out = new StdoutOutputStrategy();
        }
        int h = getInt("Height (0–23)? ", 0, 23);

        StringBuilder sb = new StringBuilder();
        for (int w = 2; w <= h+1; w++) {
            for (int i = 0; i < h+1-w; i++) {
                sb.append(' ');
            }
            for (int i = 0; i < w; i++) {
                sb.append('#');
            }
            sb.append(System.lineSeparator());
        }

        out.print(sb.toString());
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
