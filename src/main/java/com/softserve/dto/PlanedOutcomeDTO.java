package com.softserve.dto;

import java.time.LocalDate;

public class PlanedOutcomeDTO {

    private Double sum;
    private LocalDate date;
    private String note;
    private Long userId;
    private Long categoryId;

    public PlanedOutcomeDTO(Double sum, LocalDate date, String note, Long userId, Long categoryId) {
        this.sum = sum;
        this.date = date;
        this.note = note;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public PlanedOutcomeDTO() {
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
}