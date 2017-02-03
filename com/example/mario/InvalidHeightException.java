package com.example.mario;

public class InvalidHeightException extends Exception {

    public InvalidHeightException(int height, int min, int max) {
        super(
                String.format(
                        "Given height %d is not between %d and %d",
                        height, min, max
                )
        );
    }

}
