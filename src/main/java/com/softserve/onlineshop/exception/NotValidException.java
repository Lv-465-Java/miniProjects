package com.softserve.onlineshop.exception;

public class NotValidException extends RuntimeException {
    public NotValidException() {
        super();
    }

    public NotValidException(String message) {
        super(message);
    }
}
