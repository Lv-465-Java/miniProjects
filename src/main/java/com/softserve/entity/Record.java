package com.softserve.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Record {

    public static enum RecordEntityQueries {

        INSERT(SqlQueries.INSERT, "INSERT INTO records (sum, date, note, financial_type_id, user_id, category_id, planed_outcome_id) VALUES (?, ?, ?, ?, ?, ?, ?)"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, sum, date, note, financial_type_id, user_id, category_id, planed_outcome_id FROM records WHERE id = ?"),
        GET_ALL_BY_USER_ID(SqlQueries.GET_ALL_BY_USER_ID, "SELECT * FROM records WHERE user_id = ?"),
        GET_ALL_BY_USER_ID_AND_FINANCIAL_TYPE(SqlQueries.GET_ALL_BY_USER_ID_AND_FINANCIAL_TYPE, "SELECT * FROM records WHERE user_id = ? AND financial_type_id = ?"),
        GET_ALL_BY_USER_ID_AND_DATE_RANGE(SqlQueries.GET_ALL_BY_USER_ID_AND_DATE_RANGE, "SELECT * FROM records WHERE user_id = ? AND date BETWEEN ? AND ?"),
       // GET_ALL_BY_SELECTED_FILTERS(SqlQueries.GET_ALL_BY_SELECTED_FILTERS, "")
        UPDATE(SqlQueries.UPDATE, "UPDATE records SET sum = ?, date = ?, note = ?, financial_type_id = ?, user_id = ?, category_id = ?, planed_outcome_id = ? WHERE id = ?"),
        DELETE(SqlQueries.DELETE, "DELETE FROM records WHERE id = ?");

        private SqlQueries sqlQuery;
        private String query;

        RecordEntityQueries(SqlQueries sqlQuery, String query) {
            this.sqlQuery = sqlQuery;
            this.query = query;
        }

        public SqlQueries getSqlQuery() {
            return sqlQuery;
        }

        public String getQuery() {
            return query;
        }
    }

    private Long id;
    private Double sum;
    private LocalDate date;
    private String note;
    private Long financialTypeId;
    private Long userId;
    private Long categoryId;
    private Long planedOutcomeId;

    public Record(Double sum, LocalDate date, String note, Long financialTypeId, Long userId, Long categoryId) {
        this.sum = sum;
        this.date = date;
        this.note = note;
        this.financialTypeId = financialTypeId;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public Record() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(id, record.id) &&
                Objects.equals(sum, record.sum) &&
                Objects.equals(date, record.date) &&
                Objects.equals(note, record.note) &&
                Objects.equals(financialTypeId, record.financialTypeId) &&
                Objects.equals(userId, record.userId) &&
                Objects.equals(categoryId, record.categoryId) &&
                Objects.equals(planedOutcomeId, record.planedOutcomeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sum, date, note, financialTypeId, userId, categoryId, planedOutcomeId);
    }

    @Override
    public String toString() {
        return "Record{" +
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