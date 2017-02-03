package com.example.mario;

public class StdoutPrinter implements Printer {

    public void print(Pyramid p) {
        System.out.print(p.toString());
    }

}
