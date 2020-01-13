package com.itacademy.softserve.constant;

public enum ErrorMessage {
    ERROR("error"),
    INCORRECT_DATA("Please try again. You enter incorrect data("),
    BAD_LOGIN_OR_PASSWORD("Bad Login or Password"),
    SUCH_USER_EXIST("Such user already exist"),
    SUCH_TASK_EXIST("Such task already exist"),
    NO_INFO("No info on your request("),
    EMPTY_NAME("Name field is empty"),
    SORRY_MESSAGE("At the moment we cannot perform this operation");

    private String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
