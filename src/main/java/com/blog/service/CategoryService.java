package com.blog.service;

import com.blog.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAll();
    CategoryDto getById(Long id);
}
