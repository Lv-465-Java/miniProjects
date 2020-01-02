package com.softserve.constant;

public enum ErrorMessage {
    FAIL_TO_CREATE_CONNECTION("FAIL TO CREATE CONNECTION TO DATABASE"),
    FAIL_TO_READ_DATABASE_PROPERTIES("FAIL TO READ DATABASE PROPERTIES FROM FILE"),
    FAIL_TO_CLOSE_CONNECTION("FAIL TO CREATE CONNECTION TO DATABASE"),
    FAIL_TO_REGISTER_A_USER("Such email is already used"),
    FAIL_TO_LOGIN_WITH_WRONG_EMAIL("Entered password isn't correct"),
    FAIL_TO_LOGIN_WITH_WRONG_PASSWORD("User with entered email isn't created yet");


    String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}