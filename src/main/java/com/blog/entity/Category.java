package com.blog.entity;

public class Category implements IEntity{

    public static enum CategoryEntityQueries{
        INSERT(SqlQueries.INSERT, "INSERT INTO categories (name) VALUES (?);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, name FROM categories WHERE id = ?;"),
        GET_BY_CATEGORY(SqlQueries.GET_BY_FIELD, "SELECT id, text, created_date FROM categories WHERE post_id = ?;"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, name FROM categories;"),
 //       SEARCH(SqlQueries.SEARCH, "SELECT id, name FROM categories WHERE %s LIKE %?%;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE categories SET name = %s WHERE id = %s;"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM categories WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM categories WHERE %s = %s;");

        private SqlQueries sqlQuery;
        private String query;

        private CategoryEntityQueries(SqlQueries sqlQuery, String query) {
            this.sqlQuery = sqlQuery;
            this.query = query;
        }

        public SqlQueries getSqlQuery() {
            return sqlQuery;
        }

        @Override
        public String toString() {
            return  query;
        }
    }

    private Long id;
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
