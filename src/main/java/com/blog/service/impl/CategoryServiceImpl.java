package com.blog.service.impl;

import com.blog.constant.Message;
import com.blog.dao.CategoryDao;
import com.blog.dto.CategoryDto;
import com.blog.entity.Category;
import com.blog.exeption.NotFoundExeption;
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
        try {
            for (Category category : categoryDao.getAll()) {
                CategoryDto categoryDto = new CategoryDto(
                        category.getId(),
                        category.getName()
                );
                categoryDtoList.add(categoryDto);
            }
        }catch (RuntimeException e){
            throw new NotFoundExeption(Message.CATEGORY_NOT_FOUND);
        }
        return categoryDtoList;
    }

    @Override
    public CategoryDto getById(Long id) {
        try {
            Category category = categoryDao.getById(id);
            CategoryDto categoryDto = new CategoryDto(
                    category.getId(),
                    category.getName()
            );
            return categoryDto;
        }catch (RuntimeException e){
            throw new NotFoundExeption(Message.CATEGORY_NOT_FOUND);
        }
    }

}
