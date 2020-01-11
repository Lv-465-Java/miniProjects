package com.softserve.entity;

public enum FinancialType {
    INCOME(1L, "Income"),
    OUTCOME(2L, "Outcome");

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