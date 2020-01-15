package com.blog.controller;

public enum ControllerUrls {

    HOME_PAGE(""),
    USER_POSTS("/user/posts"),
    PROFILE("/profile"),
    ADMIN_PAGE("/admin");

    private String url;

    ControllerUrls(String url) {
        this.url = url;
    }

    @Override
    public String toString(){
        return url;
    }
}
