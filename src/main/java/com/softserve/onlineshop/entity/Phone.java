package com.softserve.onlineshop.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Phone {

    private Long id;
    private Integer year;
    private Integer price;
    private String photo;
    private String color;
    private Double screenDiagonal;
    private Integer internalMemory;
    private Long idModel;

    public static enum PhoneEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO phones (year, price, photo, color, screenDiagonal, "
                + "internalMemory,idModel) VALUES ('%s', '%s', %s, %s, %s, %s, %s);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name, description, idUser FROM items WHERE id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, name, description, idUser FROM items WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, name, description, idUser FROM items;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE items SET name = '%s', description = '%s' WHERE id = %s;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE items SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM items WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM items WHERE %s = '%s';");

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
