package org.example;

public class IllegalArgException extends RuntimeException{

    public IllegalArgException() {
        super("Argument length should be higher than 2 ");
    }
}
