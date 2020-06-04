package com.example.furnitureshop.exceptions;

public class EmptyCartException extends RuntimeException {

    public EmptyCartException() {
        super("Cart cannot be empty");
    }

    public EmptyCartException(String s) {
        super(s);
    }
}
