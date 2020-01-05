package com.softserve.onlineshop.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User implements Entity {

    private Long id;
    private String nickname;
    private String password;
    private String email;
    private String phone;
    private Long cartId;

    public enum UserEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO users (nickname, password, email, phone, cartId) VALUES (?, ?, ?, ?, ?);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, nickname, password, email, phone, cartId FROM users WHERE id = ?;"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, nickname, password, email, phone, cartId FROM users;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE users SET nickname = ?, password = ?, email = ?, phone = ?, cartId = ? WHERE id = ?;"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM users WHERE id = ?;");

        private SqlQueries sqlQuery;
        private String query;

        UserEntityQueries(SqlQueries sqlQuery, String query) {
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
