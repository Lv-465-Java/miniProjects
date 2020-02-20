package constant;

public enum JspUrl {
    LOGIN_JSP ("/login.jsp"),
    SIGNUP_JSP ("/WEB-INF/view/signup.jsp"),
    HOME_JSP ("/WEB-INF/view/home.jsp"),
    HABIT_JSP("/WEB-INF/view/habit.jsp"),
    CREATE_HABIT_JSP("/WEB-INF/view/create_habit.jsp"),
    EDIT_HABIT_DESCRIPTION_JSP("/WEB-INF/view/edit_habit_description.jsp"),
    EDIT_USER_JSP ("/WEB-INF/view/edit_user.jsp"),
    DELETE_USER_JSP("/WEB-INF/view/delete_user.jsp"),
    DELETE_HABIT_JSP("/WEB-INF/view/delete_habit.jsp");

    private String path;

    JspUrl(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return path;
    }
}
