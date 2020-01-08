package com.softserve.dto;

import java.time.LocalDate;

public class RecordDTO {
    private Long id;
    private Double sum;
    private LocalDate date;
    private String note;
    private Long financialTypeId;
    private Long userId;
    private Long categoryId;
    private Long planedOutcomeId;

    public RecordDTO(Long id, Double sum, LocalDate date, String note, Long financialTypeId, Long userId, Long categoryId, Long planedOutcomeId) {
        this.id = id;
        this.sum = sum;
        this.date = date;
        this.note = note;
        this.financialTypeId = financialTypeId;
        this.userId = userId;
        this.categoryId = categoryId;
        this.planedOutcomeId = planedOutcomeId;
    }

    public RecordDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getFinancialTypeId() {
        return financialTypeId;
    }

    public void setFinancialTypeId(Long financialTypeId) {
        this.financialTypeId = financialTypeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getPlanedOutcomeId() {
        return planedOutcomeId;
    }

    public void setPlanedOutcomeId(Long planedOutcomeId) {
        this.planedOutcomeId = planedOutcomeId;
    }
}
