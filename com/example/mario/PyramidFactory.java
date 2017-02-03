package com.example.mario;

public class PyramidFactory {

    public static PyramidFactory getInstance() {
        if (factory == null) {
            factory = new PyramidFactory();
        }
        return factory;
    }
    public Pyramid pyramid(int height) throws InvalidHeightException {
        return new Pyramid(height);
    }

    private PyramidFactory() {}

    private static PyramidFactory factory;

}
