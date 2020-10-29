package com.example.demo.exceptions;

public class IdAlreadyExists extends RuntimeException {
    public IdAlreadyExists(String message) {
        super(message);
    }
}
