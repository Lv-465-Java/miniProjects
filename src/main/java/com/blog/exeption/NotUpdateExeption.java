package com.blog.exeption;

public class NotUpdateExeption extends RuntimeException {

    public NotUpdateExeption(String message) {
        super(message);
    }
}
