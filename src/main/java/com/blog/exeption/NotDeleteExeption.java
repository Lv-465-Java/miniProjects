package com.blog.exeption;

public class NotDeleteExeption extends RuntimeException {

    public NotDeleteExeption(String message) {
        super(message);
    }
}
