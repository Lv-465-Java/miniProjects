package com.blog.entity;

public class Role {
    public static enum RoleEntityQueries {

        INSERT(SqlQueries.INSERT, "INSERT INTO roles (name) values (?);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name FROM roles WHERE id = ?; "),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD,"SELECT id, name from roles WHERE name = ?; "),
        GET_BY_FIELD_LIKE(SqlQueries.GET_BY_FIELD_LIKE, "SELECT id, name FROM roles WHERE %s LIKE %?%;"),
        GET_ALL(SqlQueries.GET_ALL , "SELECT id, name from roles;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE roles SET name = %s WHERE id = ?;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD,  "UPDATE roles SET %s = %s WHERE %s = ?;"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM roles where id = ?;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD , "DELETE FROM roles where %s = ?;");

        private SqlQueries sqlQueries;
        private String query;

        private RoleEntityQueries(SqlQueries sqlQueries, String query) {
            this.sqlQueries = sqlQueries;
            this.query = query;
        }

        public SqlQueries getSqlQueries() {
            return sqlQueries;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    private Long id;
    private String name;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
