package com.softserve.entity;

public enum FinancialType {
    INCOME(1L, "INCOME"),
    OUTCOME(2L, "OUTCOME");

    Long id;
    String typeName;

    FinancialType(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public Long getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }
}