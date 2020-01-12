package com.softserve.constant;

public enum View {
    LOGIN_PAGE("/login.jsp"),
    REGISTRATION_PAGE("/signUp.jsp"),
    USER_PROFILE_PAGE("/profile.jsp"),
    USER_EDIT_PAGE("/editUser.jsp"),
    USER_CHANGE_PASSWORD("/changePassword.jsp"),
    CATEGORY_ADD_PAGE("/addCategory.jsp"),
    CATEGORY_EDIT_PAGE("/editCategory.jsp"),
    USER_EDIT("/editUser.jsp"),
    CATEGORY_DELETE_PAGE("/deleteCategory.jsp"),
    RECORD_DASHBOARD_PAGE("/recordDashboard.jsp"),
    RECORD_ADD_PAGE("/addRecord.jsp"),
    RECORD_EDIT_PAGE("/editRecord.jsp"),
    RECORD_DELETE_PAGE("/deleteRecord.jsp"),
    PLANNED_OUTCOME_DASHBOARD_PAGE("/plannedOutcomeDashboard.jsp"),
    PLANNED_OUTCOME_ADD_PAGE("/addPlannedOutcome.jsp"),
    PLANNED_OUTCOME_EDIT_PAGE("/editPlannedOutcome.jsp"),
    PLANNED_OUTCOME_DELETE_PAGE("/deletePlannedOutcome.jsp");

    String viewUrl;

    View(String viewUrl) {
        this.viewUrl = viewUrl;
    }

    public String getViewUrl() {
        return viewUrl;
    }


}
