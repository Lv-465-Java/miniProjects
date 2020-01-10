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
        ADD_TO_CART(SqlQueries.INSERT, "INSERT INTO carts (phoneId, userId) VALUES (?, ?);"),
        GET_BY_PHONE_ID(SqlQueries.GET_BY_ID, "SELECT phoneId, userId, dateOfBuying FROM carts WHERE phoneId = ?;"),
        GET_BY_USER_ID(SqlQueries.GET_BY_USER_ID, "SELECT phoneId, userId, dateOfBuying FROM carts WHERE userId = ?;"),
        BUY_PRODUCT(SqlQueries.UPDATE_BY_ID, "UPDATE carts SET dateOfBuying = ? WHERE phoneId = ?;"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM carts WHERE phoneId = ?;");

        private SqlQueries sqlQuery;
        private String query;

        CartEntityQueries(SqlQueries sqlQuery, String query) {
            this.sqlQuery = sqlQuery;
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
