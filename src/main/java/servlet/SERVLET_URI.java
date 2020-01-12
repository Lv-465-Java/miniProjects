package servlet;

public enum SERVLET_URI {

    LOGIN_SERVLET("/login"),
    REGISTRATION_SERVLET("/registration"),
    INITIALIZER_SERVLET("/initDB");


    private String uri;

    SERVLET_URI(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
