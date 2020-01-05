package com.softserve.onlineshop.exception;

public class NotDeletedException extends RuntimeException {
    public NotDeletedException() {
        super();
    }

    public NotDeletedException(String message) {
        super(message);
    }
}
