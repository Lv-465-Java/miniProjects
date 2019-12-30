package com.softserve.entity;

import java.time.LocalDate;
import java.util.Objects;

public class PlanedOutcome {

    public static enum PlanedOutcomeEntityQueries {

        INSERT(SqlQueries.INSERT, "INSERT INTO planed_outcomes (sum, date, note, user_id, category_id) VALUES (?, ?, ?, ?, ?)"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, sum, date, note, user_id, category_id FROM planed_outcomes WHERE id = ?"),
        GET_ALL_BY_USER_ID(SqlQueries.GET_ALL_BY_USER_ID, "SELECT * FROM planed_outcomes WHERE user_id = ?"),
        GET_ALL_BY_USER_ID_AND_DATE_RANGE(SqlQueries.GET_ALL_BY_USER_ID_AND_DATE_RANGE, "SELECT * FROM planed_outcomes WHERE user_id = ? AND date BETWEEN ? AND ?"),
        UPDATE(SqlQueries.UPDATE, "UPDATE planed_outcomes SET sum = ?, date = ?, note = ?, user_id = ?, category_id = ? WHERE id = ?"),
        DELETE(SqlQueries.DELETE, "DELETE FROM planed_outcomes WHERE id = ?");

        private SqlQueries sqlQuery;
        private String query;

        PlanedOutcomeEntityQueries(SqlQueries sqlQuery, String query) {
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
    private Long userId;
    private Long categoryId;

    public PlanedOutcome(Double sum, LocalDate date, String note, Long userId, Long categoryId) {
        this.sum = sum;
        this.date = date;
        this.note = note;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public PlanedOutcome() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanedOutcome that = (PlanedOutcome) o;
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
        return "PlanedOutcome{" +
                "id=" + id +
                ", sum=" + sum +
                ", date=" + date +
                ", note='" + note + '\'' +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                '}';
    }
}