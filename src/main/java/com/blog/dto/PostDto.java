package com.blog.dto;

public class PostDto {

    private Long id;
    private String title;
    private String content;
    private String imgPath;
    private String createdDate;
    private String updatedDate;
    private Long userId;
    private Long categoryId;
    private String author;
    private String category;

    public PostDto() {
    }

    public PostDto(Long id, String title, String content, String imgPath, String createdDate, String updatedDate, Long userId, Long categoryId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imgPath = imgPath;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public PostDto(String title, String content, String imgPath, String createdDate, String updatedDate, Long userId, Long categoryId) {
        this.title = title;
        this.content = content;
        this.imgPath = imgPath;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public PostDto(Long id, String title, String content, String imgPath, String createdDate, String updatedDate, Long userId, Long categoryId, String author, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imgPath = imgPath;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.userId = userId;
        this.categoryId = categoryId;
        this.author = author;
        this.category = category;
    }


    public PostDto(String title, String content, String imgPath, Long categoryId) {
        this.title = title;
        this.content = content;
        this.imgPath = imgPath;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
