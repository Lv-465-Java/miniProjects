package com.softserve.onlineshop.exception;

public class NotInsertedException extends RuntimeException {
    public NotInsertedException() {
        super();
    }

    public NotInsertedException(String message) {
        super(message);
    }
}
