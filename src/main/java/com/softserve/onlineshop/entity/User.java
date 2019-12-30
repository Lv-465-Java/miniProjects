package com.softserve.onlineshop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private Long id;
    private String nickname;
    private String password;
    private String email;
    private String phone;
    private Long cartId;

    public static enum PhoneEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO users (nickname, password, email, phone, cartId) VALUES ('%s', '%s', '%s', '%s', %s);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, nickname, password, email, phone, cartId FROM users WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, nickname, password, email, phone, cartId FROM users WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, nickname, password, email, phone, cartId FROM users;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE users SET nickname = '%s', password = '%s', email = '%s', phone = '%s' WHERE id = %s;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE users SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM users WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM users WHERE %s = '%s';");

        private SqlQueries sqlQuery;
        private String query;

        PhoneEntityQueries(SqlQueries sqlQuery, String query) {
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
