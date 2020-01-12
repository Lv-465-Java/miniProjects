package com.softserve.dao.implementation;

import com.softserve.dao.RecordDAO;
import com.softserve.dao.mapping.CategoryMapping;
import com.softserve.database.DataBaseConnection;
import com.softserve.database.JDBCQueries;
import com.softserve.entity.Category;
import com.softserve.exception.NoSuchEntityException;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class CategoryDAOImpl implements RecordDAO<Category> {
    private Connection connection;

    public CategoryDAOImpl() {
        this.connection = DataBaseConnection.getInstance().getConnection();
    }

    @Override
    public boolean save(Category category) {
        return JDBCQueries.update(connection, Category.CategoryEntityQueries.INSERT.getQuery(),
                category.getTitle(), category.getColor(), category.getDescription(), category.getUserId(),
                category.getFinancialTypeId());
    }

    @Override
    public Optional<Category> getById(Long id) throws NoSuchEntityException {
        return JDBCQueries.getObject(connection, Category.CategoryEntityQueries.GET_BY_ID.getQuery(),
                new CategoryMapping(), id);
    }

    @Override
    public List<Category> getAllByUserId(Long userId) {
        return JDBCQueries.getListOfObjects(connection, Category.CategoryEntityQueries.GET_ALL_BY_USER_ID.getQuery(),
                new CategoryMapping(), userId);
    }

    @Override
    public List<Category> getAllByUserIdAndFinancialTypeId(Long userId, Long typeId) {
        return JDBCQueries.getListOfObjects(connection,
                Category.CategoryEntityQueries.GET_ALL_BY_USER_ID_AND_FINANCIAL_TYPE.getQuery(), new CategoryMapping(),
                userId, typeId);
    }

    @Override
    public boolean update(Long id, Category category) {
        return JDBCQueries.update(connection, Category.CategoryEntityQueries.UPDATE.getQuery(),
                category.getTitle(), category.getColor(), category.getDescription(), category.getUserId(),
                category.getFinancialTypeId(), id);
    }

    @Override
    public boolean delete(Long id) {
        return JDBCQueries.update(connection, Category.CategoryEntityQueries.DELETE.getQuery(), id);
    }
}