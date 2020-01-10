package com.softserve.onlineshop.entity;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cart {

    private Long phoneId;
    private Long userId;
    private LocalDateTime dateOfBuying;

    public Cart(Long phoneId, Long userId, LocalDateTime dateOfBuying) {
        this.phoneId = phoneId;
        this.userId = userId;
        this.dateOfBuying = dateOfBuying;
    }

    public Cart(Long phoneId, Long userId) {
        this.phoneId = phoneId;
        this.userId = userId;
    }

    public enum CartEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO carts (phoneId, userId, dateOfBuying) VALUES (?, ?, ?);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name, producerId FROM models WHERE id = ?;"),
        GET_BY_USER_ID("SELECT phoneId, userId, dateOfBuying FROM carts WHERE userId = ?;"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, name, producerId FROM models;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, name, producerId FROM models WHERE name = '%s';"),
        GET_BY_PRODUCER_ID(SqlQueries.GET_BY_PRODUCER_ID, "SELECT id, name, producerId FROM models WHERE producerId = ?;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE models SET name = ?, producerId = ? WHERE id = ?;"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM models WHERE id = ?;");

        private SqlQueries sqlQuery;
        private String query;

        CartEntityQueries(SqlQueries sqlQuery, String query) {
            this.sqlQuery = sqlQuery;
            this.query = query;
        }

        CartEntityQueries(String query) {
            this.query = query;
        }


        public SqlQueries getSqlQuery() {
            return this.sqlQuery;
        }

        public String toString() {
            return this.query;
        }
    }
}
