package com.softserve.onlineshop.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Phone implements Entity {

    private Long id;
    private Integer year;
    private Integer price;
    private String photo;
    private String color;
    private Double screenDiagonal;
    private Integer internalMemory;
    private Long modelId;
    private Long cartId;

    public Phone(Integer year, Integer price, String photo, String color, Double screenDiagonal, Integer internalMemory, Long modelId) {
        this.year = year;
        this.price = price;
        this.photo = photo;
        this.color = color;
        this.screenDiagonal = screenDiagonal;
        this.internalMemory = internalMemory;
        this.modelId = modelId;
    }

    public enum PhoneEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO phones (year, price, photo, color, screenDiagonal, "
                + "internalMemory, modelId) VALUES (? , ?, ?, ?, ?, ?, ?);"),
//        INSERT(SqlQueries.INSERT, "INSERT INTO phones (year, price, photo, color, screenDiagonal, "
//                + "internalMemory, modelId) VALUES ('%s', '%s', %s, '%s', %s, %s, %s);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, year, price, photo, color, " +
                "screenDiagonal, internalMemory, modelId FROM phones WHERE id = ?;"),
//        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, year, price, photo, color, " +
//                "screenDiagonal, internalMemory, modelId FROM phones WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, year, price, photo, color, " +
                "screenDiagonal, internalMemory, modelId FROM phones WHERE year = '%s';"),
//        GET_BY_FIELDS(SqlQueries.GET_BY_FIELD, "SELECT id, year, price, photo, color, " +
//                "screenDiagonal, internalMemory, modelId FROM phones WHERE %s;"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, year, price, photo, color," +
                "screenDiagonal, internalMemory, modelId FROM phones;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE phones SET year = ?, price = ?, photo = ?, " +
                "color = ?, screenDiagonal = ?, internalMemory = ?, modelId = ? WHERE id = ?;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE phones SET %s = %s WHERE %s = %s;"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM phones WHERE id = ?;");

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
