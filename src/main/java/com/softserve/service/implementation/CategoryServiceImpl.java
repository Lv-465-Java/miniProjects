package com.softserve.service.implementation;

import com.softserve.constant.ErrorMessage;
import com.softserve.dao.implementation.CategoryDAOImpl;
import com.softserve.dto.CategoryDTO;
import com.softserve.entity.Category;
import com.softserve.entity.FinancialType;
import com.softserve.exception.NoSuchEntityException;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.ReadAllService;
import com.softserve.service.mapper.CategoryMapperObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryServiceImpl implements ReadAllService<CategoryDTO> {

    private CategoryDAOImpl categoryDAO;

    public CategoryServiceImpl() {
        this.categoryDAO = new CategoryDAOImpl();
    }

    @Override
    public boolean create(CategoryDTO categoryDTO) throws NotCompletedActionException {
        Category category = new Category(categoryDTO.getTitle(), categoryDTO.getColor(), categoryDTO.getDescription(),
                categoryDTO.getUserId(), categoryDTO.getFinancialTypeId());
        if (!categoryDAO.save(category)) {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_SAVE_A_CATEGORY.getErrorMessage());
        }
        return true;
    }

    @Override
    public CategoryDTO getById(Long id) throws NoSuchEntityException {
        Category category = CategoryMapperObjects.verifyIfCategoryIsPresent(categoryDAO.getById(id));
        return CategoryMapperObjects.categoryEntityToCategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllByUserId(Long id) {
        List<CategoryDTO> listDTO = new ArrayList<>();
        List<Category> list = categoryDAO.getAllByUserId(id);
        for (Category category : list) {
            listDTO.add(CategoryMapperObjects.categoryEntityToCategoryDTO(category));
        }
        return listDTO;
    }

    @Override
    public boolean update(Long id, CategoryDTO categoryDTO) throws NoSuchEntityException, NotCompletedActionException {
        Category category = CategoryMapperObjects.verifyIfCategoryIsPresent(categoryDAO.getById(categoryDTO.getId()));
        category.setTitle(categoryDTO.getTitle());
        category.setColor(categoryDTO.getColor());
        category.setDescription(categoryDTO.getDescription());
        category.setFinancialTypeId(categoryDTO.getFinancialTypeId());
        if (!categoryDAO.update(id, category)) {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_UPDATE_A_CATEGORY.getErrorMessage());
        }
        return true;
    }

    @Override
    public boolean delete(Long id) throws NotCompletedActionException {
        if (!categoryDAO.delete(id)) {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_DELETE_A_CATEGORY.getErrorMessage());
        }
        return true;
    }

    @Override
    public List<FinancialType> getTypes() {
        return Arrays.asList(FinancialType.values());
    }
}