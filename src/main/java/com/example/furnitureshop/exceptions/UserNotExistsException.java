package com.example.furnitureshop.exceptions;

public class UserNotExistsException extends RuntimeException {
    public UserNotExistsException(String s) {
        super(s);
    }
}
