package com.softserve.onlineshop.exception;

public class NotUpdatedException extends RuntimeException {
    public NotUpdatedException() {
        super();
    }

    public NotUpdatedException(String message) {
        super(message);
    }
}
