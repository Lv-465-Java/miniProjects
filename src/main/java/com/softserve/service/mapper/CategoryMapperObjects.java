package com.softserve.service.mapper;

import com.softserve.constant.ErrorMessage;
import com.softserve.dto.CategoryDTO;
import com.softserve.entity.Category;
import com.softserve.entity.User;

import java.util.Optional;

public class CategoryMapperObjects {

    public static CategoryDTO categoryEntityToCategoryDTO(Category entity) {
        return new CategoryDTO(entity.getId(), entity.getTitle(), entity.getColor(), entity.getDescription(),
                entity.getUserId(), entity.getFinancialTypeId());
    }

    public static Category verifyIfCategoryIsPresent(Optional<Category> optionalCategory) {
        if (!optionalCategory.isPresent()) {
            throw new RuntimeException(ErrorMessage.FAIL_TO_FIND_A_CATEGORY.getErrorMessage());
        }
        return optionalCategory.get();
    }
}