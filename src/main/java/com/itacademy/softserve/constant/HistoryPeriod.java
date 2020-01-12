package com.itacademy.softserve.constant;

public enum  HistoryPeriod {
    PERIOD("period"),
    TODAY("today"),
    LAST_WEEK("last week"),
    LAST_MONTH("last month"),
    LAST_YEAR("last year"),
    ALL("all");

    private String value;

    private HistoryPeriod(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
