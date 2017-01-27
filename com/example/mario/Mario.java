// I control zero internet domains, so this is as proper as it’s
// going to get.
package com.example.mario;

import java.lang.String;
import java.lang.Integer;
import java.io.Console;

class Mario {
    public static void main(String[] args) {
        int h;
        h = getInt("Height? ", 0, 23);
        for (int w = 2; w <= h+1; w++) {
            for (int i = 0; i < h+1-w; i++) {
                System.out.print(' ');
            }
            for (int i = 0; i < w; i++) {
                System.out.print('#');
            }
            System.out.println();
        }
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
