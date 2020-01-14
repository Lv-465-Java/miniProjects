package servlet;

public enum JSPFILES {

    LOGIN_JSP("/WEB-INF/views/login.jsp"),
    REGISTRATION_JSP("/WEB-INF/views/registration.jsp"),
    CREATE_TRIP("/WEB-INF/views/createTrip.jsp"),
    FORGOT_PASSWORD("/WEB-INF/views/forgotPassword.jsp"),
    MESSAGE("/WEB-INF/views/message.jsp"),
    EDIT_USER("/WEB-INF/views/editUser.jsp"),
    CREATE_COMMENT("/WEB-INF/views/createComment.jsp"),
    CREATE_PLACE("/WEB-INF/views/createPlace.jsp"),
    MAIN_PAGE("/WEB-INF/views/mainPage.jsp"),
    PERSONAL_CABINET("/WEB-INF/views/personalCabinet.jsp"),
    COMMENT_LIST("/WEB-INF/views/commentList.jsp"),
    TRIP_LIST("/WEB-INF/views/tripList.jsp"),
    USER_LIST("/WEB-INF/views/userList.jsp"),
    PLACE_LIST("/WEB-INF/views/placeList.jsp"),
    TRANSPORT_LIST("/WEB-INF/views/transportList.jsp"),
    ADMIN_PAGE("/WEB-INF/views/adminPage.jsp"),
    EDIT_COMMENT("/WEB-INF/views/editComment.jsp"),
    EDIT_PLACE("/WEB-INF/views/editPlace.jsp"),
    EDIT_PLACE_DESCRIPTION("/WEB-INF/views/editPlaceDescription.jsp"),
    CREATE_TRANSPORT("/WEB-INF/views/createTransport.jsp"),
    SEARCH_PLACE_BY_TEMPLATE("/WEB-INF/views/searchPlaceByTemplate.jsp"),
    ADD_PLACE_TO_TRIP("/WEB-INF/views/addPlaceToTrip.jsp"),
    UPLOAD_FILE("/WEB-INF/views/uploadPoster.jsp"),
    EVALUATE_PLACE("/WEB-INF/views/evaluatePlace.jsp");


    private String path;

    JSPFILES(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
