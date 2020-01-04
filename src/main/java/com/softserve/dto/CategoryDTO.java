package com.softserve.dto;

public class CategoryDTO {

    private Long id;
    private String title;
    private String color;
    private String description;
    private Long userId;
    private Long financialTypeId;

    public CategoryDTO(Long id, String title, String color, String description, Long userId, Long financialTypeId) {
        this.id = id;
        this.title = title;
        this.color = color;
        this.description = description;
        this.userId = userId;
        this.financialTypeId = financialTypeId;
    }

    public CategoryDTO() {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFinancialTypeId() {
        return financialTypeId;
    }

    public void setFinancialTypeId(Long financialTypeId) {
        this.financialTypeId = financialTypeId;
    }
}