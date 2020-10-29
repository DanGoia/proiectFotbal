package com.example.demo.exceptions;

public class TeamNotFoundException extends RuntimeException{
    public TeamNotFoundException(String s) {
        super(s);
    }
}
