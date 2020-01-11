package com.softserve.service.mapper;

import com.softserve.constant.ErrorMessage;
import com.softserve.dto.CategoryDTO;
import com.softserve.entity.Category;
import com.softserve.exception.NoSuchEntityException;

import java.util.Optional;

public class CategoryMapperObjects {

    public static CategoryDTO categoryEntityToCategoryDTO(Category entity) {
        return CategoryDTO.Builder.aCategoryDTO()
                .withId(entity.getId())
                .withTitle(entity.getTitle())
                .withColor(entity.getColor())
                .withDescription(entity.getDescription())
                .withUserId(entity.getUserId())
                .withFinancialTypeId(entity.getFinancialTypeId())
                .build();
    }

    public static Category verifyIfCategoryIsPresent(Optional<Category> optionalCategory) throws NoSuchEntityException{
        if (!optionalCategory.isPresent()) {
            throw new NoSuchEntityException(ErrorMessage.FAIL_TO_FIND_A_CATEGORY.getErrorMessage());
        }
        return optionalCategory.get();
    }
}