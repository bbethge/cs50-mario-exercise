package com.example.mario;

import java.io.IOException;

public interface OutputStrategy {

    public void print(String s) throws IOException;

    public void close() throws IOException;

}
