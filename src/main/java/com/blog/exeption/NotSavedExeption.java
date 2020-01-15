package com.blog.exeption;

public class NotSavedExeption extends RuntimeException {

    public NotSavedExeption(String message) {
        super(message);
    }
}
