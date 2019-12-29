package com.softserve.dao.implementation;

import com.softserve.dao.SearchDAO;
import com.softserve.entity.Category;

import java.util.List;
import java.util.Optional;

public class CategoryDAOImpl implements SearchDAO<Category> {
    public CategoryDAOImpl() {
        super();
    }

    @Override
    public List<Category> getAllByUserId(Long id) {
        return null;
    }

    @Override
    public Long save(Category category) {
        return null;
    }

    @Override
    public Optional<Category> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Category object, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
