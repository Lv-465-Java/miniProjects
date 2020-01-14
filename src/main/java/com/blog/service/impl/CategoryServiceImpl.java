package com.blog.service.impl;

import com.blog.dao.CategoryDao;
import com.blog.dto.CategoryDto;
import com.blog.entity.Category;
import com.blog.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    public CategoryServiceImpl() {
        this.categoryDao = new CategoryDao();
    }

    @Override
    public List<CategoryDto> getAll() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for (Category category: categoryDao.getAll()) {
            CategoryDto categoryDto = new CategoryDto(
                    category.getId(),
                    category.getName()
            );
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }

    @Override
    public CategoryDto getById(Long id) {
        Category category = categoryDao.getById(id);
        CategoryDto categoryDto = new CategoryDto(
                category.getId(),
                category.getName()
        );
        return categoryDto;
    }

}
