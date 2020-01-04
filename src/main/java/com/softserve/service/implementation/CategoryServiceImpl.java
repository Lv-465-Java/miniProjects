package com.softserve.service.implementation;

import com.softserve.constant.ErrorMessage;
import com.softserve.dao.implementation.CategoryDAOImpl;
import com.softserve.dto.CategoryDTO;
import com.softserve.entity.Category;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.CrudService;
import com.softserve.service.mapper.CategoryMapperObjects;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CrudService<CategoryDTO> {

    private CategoryDAOImpl categoryDAO;

    public CategoryServiceImpl() {
        this.categoryDAO = new CategoryDAOImpl();
    }

    @Override
    public boolean create(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.getTitle(), categoryDTO.getColor(), categoryDTO.getDescription(),
                categoryDTO.getUserId(), categoryDTO.getFinancialTypeId());
        return categoryDAO.save(category);
    }

    public List<CategoryDTO> getAllByUserId(Long id) {
        List<CategoryDTO> listDTO = new ArrayList<>();
        List<Category> list = categoryDAO.getAllByUserId(id);
        for (Category category : list) {
            listDTO.add(CategoryMapperObjects.categoryEntityToCategoryDTO(category));
        }
        return listDTO;
    }

    @Override
    public CategoryDTO getById(Long id) {
        Category category = CategoryMapperObjects.verifyIfCategoryIsPresent(categoryDAO.getById(id));
        return CategoryMapperObjects.categoryEntityToCategoryDTO(category);
    }

    //test on web!!! test if you really need if-s
    @Override
    public boolean update(Long id, CategoryDTO categoryDTO) {
        Category category = new Category();
        if (categoryDTO.getTitle() != null) {
            category.setTitle(categoryDTO.getTitle());
        }
        if (categoryDTO.getFinancialTypeId() != null) {
            category.setFinancialTypeId(categoryDTO.getFinancialTypeId());
        }
        category.setColor(categoryDTO.getColor());
        category.setDescription(categoryDTO.getDescription());
        return categoryDAO.update(id, category);
    }

    @Override
    public boolean delete(Long id) {
        if (!categoryDAO.delete(id)) {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_FIND_A_CATEGORY.getErrorMessage());
        }
        return true;
    }
}