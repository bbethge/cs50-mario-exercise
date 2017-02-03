package com.example.mario;

public class PyramidFactory {

    /*
     * What does this buy us???
     */
    public static Pyramid pyramid(int height) throws InvalidHeightException {
        return new Pyramid(height);
    }
}
