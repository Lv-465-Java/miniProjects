package com.softserve.dto;

import java.time.LocalDate;
import java.util.Objects;

public class PlanedOutcomeDTO {
    private Long id;
    private Double sum;
    private LocalDate date;
    private String note;
    private Long userId;
    private Long categoryId;

    public PlanedOutcomeDTO() {
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

    public static final class Builder {
        private Long id;
        private Double sum;
        private LocalDate date;
        private String note;
        private Long userId;
        private Long categoryId;

        private Builder() {
        }

        public static Builder aPlanedOutcomeDTO() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withSum(Double sum) {
            this.sum = sum;
            return this;
        }

        public Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder withNote(String note) {
            this.note = note;
            return this;
        }

        public Builder withUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder withCategoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public PlanedOutcomeDTO build() {
            PlanedOutcomeDTO planedOutcomeDTO = new PlanedOutcomeDTO();
            planedOutcomeDTO.setId(id);
            planedOutcomeDTO.setSum(sum);
            planedOutcomeDTO.setDate(date);
            planedOutcomeDTO.setNote(note);
            planedOutcomeDTO.setUserId(userId);
            planedOutcomeDTO.setCategoryId(categoryId);
            return planedOutcomeDTO;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanedOutcomeDTO that = (PlanedOutcomeDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(sum, that.sum) &&
                Objects.equals(date, that.date) &&
                Objects.equals(note, that.note) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sum, date, note, userId, categoryId);
    }

    @Override
    public String toString() {
        return "PlanedOutcomeDTO{" +
                "id=" + id +
                ", sum=" + sum +
                ", date=" + date +
                ", note='" + note + '\'' +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                '}';
    }
}