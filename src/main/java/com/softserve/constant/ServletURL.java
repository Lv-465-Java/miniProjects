package com.softserve.constant;

public enum ServletURL {
    LOGIN_SERVLET("/login"),
    REGISTRATION_SERVLET("/sign_up"),
    USER_PROFILE("/profile");

    String servletURL;

    ServletURL(String servletURL) {
        this.servletURL = servletURL;
    }

    public String getServletURL() {
        return servletURL;
    }
}