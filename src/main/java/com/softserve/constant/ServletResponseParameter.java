package com.softserve.constant;

public enum ServletResponseParameter {
    USER_FIRST_NAME("first_name"),
    USER_LAST_NAME("last_name"),
    USER_EMAIL("email"),
    USER_PASSWORD("password"),
    USER_CURRENT_PASSWORD("current_password"),
    USER_NEW_PASSWORD("new_password"),
    USER_CONFIRM_PASSWORD("confirm_password");

    String servletParameter;

    ServletResponseParameter(String servletParameter) {
        this.servletParameter = servletParameter;
    }

    public String getServletParameter() {
        return servletParameter;
    }
}
