package com.softserve.dto;

public class CategoryDTO {

    private Long id;
    private String title;
    private String color;
    private String description;
    private Long userId;
    private Long financialTypeId;

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

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", financialTypeId=" + financialTypeId +
                '}';
    }


    public static final class Builder {
        private Long id;
        private String title;
        private String color;
        private String description;
        private Long userId;
        private Long financialTypeId;

        private Builder() {
        }

        public static Builder aCategoryDTO() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder withFinancialTypeId(Long financialTypeId) {
            this.financialTypeId = financialTypeId;
            return this;
        }

        public CategoryDTO build() {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(id);
            categoryDTO.setTitle(title);
            categoryDTO.setColor(color);
            categoryDTO.setDescription(description);
            categoryDTO.setUserId(userId);
            categoryDTO.setFinancialTypeId(financialTypeId);
            return categoryDTO;
        }
    }
}