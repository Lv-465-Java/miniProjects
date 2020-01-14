package com.blog.controller;

public enum ViewUrls {
    LOGIN("/WEB-INF/views/user/login.jsp"),
    REGISTRATION("/WEB-INF/views/user/registration.jsp"),
    HOME_PAGE("/WEB-INF/views/common/home.jsp"),
    USER_PROFILE("/WEB-INF/views/user/profile.jsp"),
    USER_UPDATE_PROFILE("/WEB-INF/views/user/profile_update.jsp"),
    USER_POSTS("/WEB-INF/views/post/user_posts.jsp"),
    ADMIN_PAGE("/WEB-INF/views/user/admin_page.jsp"),

    CATEGORY_CREATE("/WEB-INF/views/category/category_create.jsp"),


    POST_CREATE("/WEB-INF/views/post/post_create.jsp"),
    POST_VIEW("/WEB-INF/views/post/post_view.jsp"),
    POST_UPDATE("/WEB-INF/views/post/post_update.jsp"),
    SEARCH_RESULT("/WEB-INF/views/post/search_result.jsp");

    private String url;

    ViewUrls(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
