package com.softserve.exception;

public class NotCompletedActionException extends RuntimeException{

    public NotCompletedActionException(String message) {
        super(message);
    }
}
