package com.softserve.dto;

import java.time.LocalDate;
import java.util.Objects;

public class RecordDTO {
    private Long id;
    private Double sum;
    private LocalDate date;
    private String note;
    private Long financialTypeId;
    private Long userId;
    private Long categoryId;
    private Long planedOutcomeId;

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

    public static final class Builder {
        private Long id;
        private Double sum;
        private LocalDate date;
        private String note;
        private Long financialTypeId;
        private Long userId;
        private Long categoryId;
        private Long planedOutcomeId;

        private Builder() {
        }

        public static Builder aRecordDTO() {
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

        public Builder withFinancialTypeId(Long financialTypeId) {
            this.financialTypeId = financialTypeId;
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

        public Builder withPlanedOutcomeId(Long planedOutcomeId) {
            this.planedOutcomeId = planedOutcomeId;
            return this;
        }

        public RecordDTO build() {
            RecordDTO recordDTO = new RecordDTO();
            recordDTO.setId(id);
            recordDTO.setSum(sum);
            recordDTO.setDate(date);
            recordDTO.setNote(note);
            recordDTO.setFinancialTypeId(financialTypeId);
            recordDTO.setUserId(userId);
            recordDTO.setCategoryId(categoryId);
            recordDTO.setPlanedOutcomeId(planedOutcomeId);
            return recordDTO;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordDTO recordDTO = (RecordDTO) o;
        return Objects.equals(id, recordDTO.id) &&
                Objects.equals(sum, recordDTO.sum) &&
                Objects.equals(date, recordDTO.date) &&
                Objects.equals(note, recordDTO.note) &&
                Objects.equals(financialTypeId, recordDTO.financialTypeId) &&
                Objects.equals(userId, recordDTO.userId) &&
                Objects.equals(categoryId, recordDTO.categoryId) &&
                Objects.equals(planedOutcomeId, recordDTO.planedOutcomeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sum, date, note, financialTypeId, userId, categoryId, planedOutcomeId);
    }

    @Override
    public String toString() {
        return "RecordDTO{" +
                "id=" + id +
                ", sum=" + sum +
                ", date=" + date +
                ", note='" + note + '\'' +
                ", financialTypeId=" + financialTypeId +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                ", planedOutcomeId=" + planedOutcomeId +
                '}';
    }
}