package com.blog.dao;

import com.blog.entity.Category;
import com.blog.entity.Category.CategoryEntityQueries;

public class CategoryDao extends ADaoCRUD<Category> {

    public CategoryDao(){
        super();
        init();
    }
    @Override
    protected String[] getFields(Category entity) {
        String[] fields = new String[1];
        fields[0] = entity.getName();
        return fields;
    }

    @Override
    protected String[] getUpdateFields(Category entity) {
        String[] result = new String[2];
        result[0] = entity.getName();
        result[1] = entity.getId().toString();
        return result;
    }

    @Override
    protected Category createInstance(String[] args) {
        return new Category(
                Long.parseLong(args[0] == null ? "0" : args[0]),
                args[1] == null ? new String() : args[1]
        );
    }

    @Override
    protected void init() {
        for (CategoryEntityQueries categoryEntityQueries: CategoryEntityQueries.values()){
            sqlQueries.put(categoryEntityQueries.getSqlQuery(), categoryEntityQueries);
        }
    }
}
