package com.softserve.constant;

public enum ServletResponseParameter {
    USER_FIRST_NAME("first_name"),
    USER_LAST_NAME("last_name"),
    USER_EMAIL("email"),
    USER_PASSWORD("password"),
    USER_CURRENT_PASSWORD("current_password"),
    USER_NEW_PASSWORD("new_password"),
    USER_CONFIRM_PASSWORD("confirm_password"),
    CATEGORY_ID("category_id"),
    CATEGORY_TITLE("title"),
    CATEGORY_COLOR("color"),
    CATEGORY_DESCRIPTION("description"),
    FINANCIAL_TYPE("financial_type"),
    FINANCIAL_TYPE_ID("financial_type_id"),
    RECORD_ID("record_id"),
    SUM("sum"),
    DATE("date"),
    NOTE("note"),
    PLANNED_OUTCOME_ID("planned_outcome_id");



    String servletParameter;

    ServletResponseParameter(String servletParameter) {
        this.servletParameter = servletParameter;
    }

    public String getServletParameter() {
        return servletParameter;
    }
}
