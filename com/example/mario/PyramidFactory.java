package com.example.mario;

public class PyramidFactory {

    public PyramidFactory() {}

    public Pyramid pyramid(int height) throws InvalidHeightException {
        return new Pyramid(height);
    }

}
