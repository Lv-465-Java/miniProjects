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

    public static enum PhoneEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO phones (year, price, photo, color, screenDiagonal, "
                + "internalMemory, modelId) VALUES ('%s', '%s', %s, '%s', %s, %s, %s);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, year, price, photo, color, " +
                "screenDiagonal, internalMemory, modelId FROM phones WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, year, price, photo, color, " +
                "screenDiagonal, internalMemory, modelId FROM phones WHERE %s = '%s';"),
        GET_BY_FIELDS(SqlQueries.GET_BY_FIELD, "SELECT id, year, price, photo, color, " +
                "screenDiagonal, internalMemory, modelId FROM phones WHERE %s;"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, year, price, photo, color," +
                "screenDiagonal, internalMemory, modelId FROM phones;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE phones SET year = '%s', price = '%s', photo = '%s', " +
                "color = '%s', screenDiagonal = '%s', internalMemory = '%s', modelId = '%s' WHERE id = '%s';"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE phones SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM phones WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM phones WHERE %s = '%s';");

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
