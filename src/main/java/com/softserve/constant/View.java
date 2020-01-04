package com.softserve.constant;

public enum View {
    USER_LOGIN_PAGE("/login.jsp"),
    USER_REGISTRATION_PAGE("/signUp.jsp"),
    USER_PROFILE_PAGE("/profile.jsp");

    String viewUrl;

    View(String viewUrl) {
        this.viewUrl = viewUrl;
    }

    public String getViewUrl() {
        return viewUrl;
    }


}
