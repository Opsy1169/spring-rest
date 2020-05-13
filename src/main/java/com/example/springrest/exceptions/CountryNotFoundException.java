package com.example.springrest.exceptions;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String msg) {
        super(msg);
    }
}
