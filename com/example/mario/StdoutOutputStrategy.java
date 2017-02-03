package com.example.mario;

public class StdoutOutputStrategy implements OutputStrategy {

    public void print(String s) {
        System.out.print(s);
    }

}
