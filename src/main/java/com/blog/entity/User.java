package com.blog.entity;

public class User implements IEntity {


    public static enum UserEntityQueries{
        INSERT(SqlQueries.INSERT, "INSERT INTO Users (username, password, firstName, lastName, role_id) VALUES (?, ?, ?, ?, ?);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, username, password, firstName, lastName, role_id FROM users WHERE id = ?;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, username, password, firstName, lastName, role_id FROM Users WHERE %s = ?;"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, username, password, firstName, lastName, role_id FROM Users;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE users SET username = ?, password = ?, firstName = ?, lastName = ?, role_id = ? WHERE id = ?;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD,"UPDATE users SET %s = ? WHERE %s = ?;"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM Users WHERE id = ?;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM Users WHERE %s = ?;");
        //

        private SqlQueries sqlQuery;
        private String query;

        private UserEntityQueries(SqlQueries sqlQuery, String query){
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
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Long roleId;


    public User() {
    }

    public User(Long id, String username, String password, String firstName, String lastName, Long roleId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleId = roleId;
    }

    public User(String username, String password, String firstName, String lastName, Long roleId) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
