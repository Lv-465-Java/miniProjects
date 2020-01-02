package com.softserve.constant;

public enum ServletResponseParameter {
    USER_FIRST_NAME("first_name"),
    USER_LAST_NAME("last_name"),
    USER_EMAIL("email"),
    USER_PASSWORD("password");

    String servletParameter;

    ServletResponseParameter(String servletParameter) {
        this.servletParameter = servletParameter;
    }
}
