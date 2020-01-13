package com.softserve.exception;

public class NotCompletedActionException extends RuntimeException {

    private String message;

    public NotCompletedActionException(String message) {
        super(message);
    }

    public NotCompletedActionException() {
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
