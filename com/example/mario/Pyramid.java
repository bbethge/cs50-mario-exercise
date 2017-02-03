package com.example.mario;

public class Pyramid {

    public static final int maxHeight = 23;

    int height;

    public Pyramid(int height) throws InvalidHeightException {
        if (height < 0 || height > maxHeight) {
            throw new InvalidHeightException(height, 0, maxHeight);
        }
        this.height = height;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int w = 2; w <= height+1; w++) {
            for (int i = 0; i < height+1-w; i++) {
                sb.append(' ');
            }
            for (int i = 0; i < w; i++) {
                sb.append('#');
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
