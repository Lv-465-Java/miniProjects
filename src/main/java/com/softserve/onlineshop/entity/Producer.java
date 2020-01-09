package com.softserve.onlineshop.entity;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Producer implements Entity {

    private Long id;
    private String name;
//    private List<Model> models;


    public Producer(String name) {
        this.name = name;
    }

    public enum ProducerEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO producers (name) VALUES (?);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name FROM producers WHERE id = ?;"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, name, phone FROM producers;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, name FROM producers WHERE name = '%s';"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE producers SET name = ?, WHERE id = ?;"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM producers WHERE id = ?;");

        private SqlQueries sqlQuery;
        private String query;

        ProducerEntityQueries(SqlQueries sqlQuery, String query) {
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
