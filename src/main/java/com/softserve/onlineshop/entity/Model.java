package com.softserve.onlineshop.entity;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Model {

    private Long id;
    private String name;
    private Long producerId;
//    private List<Phone> phones;

    public enum ModelEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO models (name, producerId) VALUES (?, ?);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name, producerId FROM models WHERE id = ?;"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, name, producerId FROM models;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, name, producerId FROM models WHERE ? = '%s';"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE models SET name = ?, producerId = ? WHERE id = ?;"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM models WHERE id = ?;");

        private SqlQueries sqlQuery;
        private String query;

        ModelEntityQueries(SqlQueries sqlQuery, String query) {
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
