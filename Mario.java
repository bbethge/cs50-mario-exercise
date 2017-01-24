import java.lang.String;
import java.lang.Integer;
import java.io.Console;

class Mario {
    public static void main(String[] args) {
        Console c = System.console();
        int h;
        do {
            System.out.print("Height? ");
            String intStr = c.readLine();
            try {
                h = Integer.parseInt(intStr);
            }
            catch (NumberFormatException e) {
                h = -1;
            }
        }
        while (h < 0 || h > 23);
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
}
