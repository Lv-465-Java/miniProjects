package com.softserve.constant;

public enum ViewURL {
    USER_LOGIN_URL("login.jsp"),
    USER_REGISTRATION_URL("signUp.jsp"),
    USER_PROFILE_PAGE("profile.jsp");

    String viewUrl;

    ViewURL(String viewUrl) {
        this.viewUrl = viewUrl;
    }

    public String getViewUrl() {
        return viewUrl;
    }


}
