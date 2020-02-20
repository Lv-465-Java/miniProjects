package constant;

public interface ServletUrl {
    String LOGIN_URL="/login";
    String SIGNUP_URL="/signup";
    String HOME_URL="/home";
    String LOGOUT_URL="/logout";
    String HABIT_URL="/habit/*";
    String DO_HABIT_URL="/do_habit/*";
    String CREATE_HABIT_URL="/create_habit";
    String EDIT_HABIT_DESCRIPTION_URL="/edit_habit_description/*";
    String EDIT_USER_URL ="/edit_user";
    String DELETE_USER_URL="/delete_user";
    String DELETE_HABIT_URL="/delete_habit/*";
}
