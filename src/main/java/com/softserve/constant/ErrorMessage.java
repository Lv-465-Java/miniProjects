package com.softserve.constant;

public enum ErrorMessage {
    FAIL_TO_CREATE_CONNECTION("FAIL TO CREATE CONNECTION TO DATABASE"),
    FAIL_TO_READ_DATABASE_PROPERTIES("FAIL TO READ DATABASE PROPERTIES FROM FILE"),
    FAIL_TO_CLOSE_CONNECTION("FAIL TO CREATE CONNECTION TO DATABASE"),
    FAIL_TO_REGISTER_A_USER("Such email is already registered"),
    FAIL_TO_LOGIN_WITH_WRONG_EMAIL("User with entered email isn't created yet"),
    FAIL_TO_LOGIN_WITH_WRONG_PASSWORD("Entered password isn't correct"),
    FAIL_TO_FIND_A_USER("There is no such a user"),
    INCORRECT_CURRENT_PASSWORD("Entered current password is incorrect"),
    PASSWORDS_DO_NOT_MATCH("Entered new and confirm passwords do not match"),

    FAIL_TO_SAVE_A_CATEGORY("Fail to save a category"),
    FAIL_TO_FIND_A_CATEGORY("There is no such a category"),
    FAIL_TO_UPDATE_A_CATEGORY("Fail to update a category"),
    FAIL_TO_DELETE_A_CATEGORY("Fail to delete a category"),

    FAIL_TO_SAVE_A_RECORD("Fail to save a record"),
    FAIL_TO_FIND_A_RECORD("There is no such a record"),
    FAIL_TO_UPDATE_A_RECORD("Fail to update a record"),
    FAIL_TO_DELETE_A_RECORD("Fail to delete a record"),

    FAIL_TO_SAVE_A_PLANED_OUTCOME("Fail to save a planed outcome"),
    FAIL_TO_FIND_A_PLANED_OUTCOME("Fail to find a planed outcome"),
    FAIL_TO_UPDATE_A_PLANED_OUTCOME("Fail to update a planed outcome"),
    FAIL_TO_DELETE_A_PLANED_OUTCOME("Fail to delete a planed outcome");

    String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}