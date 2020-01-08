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


}
