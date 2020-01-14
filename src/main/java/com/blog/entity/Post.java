package com.blog.entity;


import java.time.LocalDateTime;

public class Post implements IEntity {

    public static enum PostEntityQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO posts (title, content, imgPath, created_date, updated_date, user_id, category_id) VALUES (?, ?, ?, ?, ?, ?, ?);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, title, content, imgPath, created_date, updated_date, user_id, category_id FROM Posts WHERE id = ?;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, title, content, imgPath, created_date, updated_date, user_id, category_id FROM Posts WHERE %s = ?;"),
        GET_BY_FIELD_LIKE(SqlQueries.GET_BY_FIELD_LIKE, "SELECT id, title, content, imgPath, created_date, updated_date, user_id, category_id FROM Posts WHERE %s LIKE ?;"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, title, content, imgPath, created_date, updated_date, user_id, category_id FROM Posts ORDER BY created_date DESC;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE posts SET title = ?, content = ?, imgPath = ?, updated_date = ?, category_id = ? WHERE id = ?;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE posts SET %s = ? WHERE %s = ?;"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM Posts WHERE id = ?;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM posts WHERE %s = ?;");
        //

        private SqlQueries sqlQuery;
        private String query;

        private PostEntityQueries(SqlQueries sqlQuery, String query) {
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
    private String title;
    private String content;
    private String imgPath;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
    private Long userId;
    private Long categoryId;

    public Post() {
    }

    public Post(Long id, String title, String content, String imgPath, LocalDateTime createdDateTime, LocalDateTime updatedDateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imgPath = imgPath;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
    }

    public Post(Long id, String title, String content, String imgPath, LocalDateTime createdDateTime, LocalDateTime updatedDateTime, Long userId, Long categoryId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imgPath = imgPath;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public Post(String title, String content, String imgPath, LocalDateTime createdDateTime, LocalDateTime updatedDateTime, Long userId, Long categoryId) {
        this.title = title;
        this.content = content;
        this.imgPath = imgPath;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategotyId() {
        return categoryId;
    }

    public void setCategotyId(Long categotyId) {
        this.categoryId = categotyId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", updatedDateTime=" + updatedDateTime +
                '}';
    }
}
