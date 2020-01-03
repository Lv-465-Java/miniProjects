package com.softserve.dao.implementation;

import com.softserve.dao.SearchDAO;
import com.softserve.dao.mapping.PlanedOutcomeMapping;
import com.softserve.database.DataBaseConnection;
import com.softserve.database.JDBCQueries;
import com.softserve.entity.PlanedOutcome;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class PlanedOutcomeDAOImpl implements SearchDAO<PlanedOutcome> {
    private Connection connection;

    public PlanedOutcomeDAOImpl() {
        this.connection = DataBaseConnection.getInstance().getConnection();
    }

    @Override
    public boolean save(PlanedOutcome planedOutcome) {
        return JDBCQueries.update(connection, PlanedOutcome.PlanedOutcomeEntityQueries.INSERT.getQuery(),
                planedOutcome.getSum(), planedOutcome.getDate(), planedOutcome.getNote(),
                planedOutcome.getUserId(), planedOutcome.getCategoryId());
    }

    @Override
    public Optional<PlanedOutcome> getById(Long id) {
        return JDBCQueries.getObject(connection, PlanedOutcome.PlanedOutcomeEntityQueries.GET_BY_ID.getQuery(),
                new PlanedOutcomeMapping(), id);
    }

    @Override
    public List<PlanedOutcome> getAllByUserId(Long id) {
        return JDBCQueries.getListOfObjects(connection, PlanedOutcome.PlanedOutcomeEntityQueries.GET_ALL_BY_USER_ID.getQuery(),
                new PlanedOutcomeMapping(), id);
    }

    @Override
    public boolean update(Long id, PlanedOutcome planedOutcome) {
        return JDBCQueries.update(connection, PlanedOutcome.PlanedOutcomeEntityQueries.UPDATE.getQuery(),
                planedOutcome.getSum(), planedOutcome.getDate(),
                planedOutcome.getNote(), planedOutcome.getUserId(), planedOutcome.getCategoryId(), id);
    }

    @Override
    public boolean delete(Long id) {
        return JDBCQueries.update(connection, PlanedOutcome.PlanedOutcomeEntityQueries.DELETE.getQuery(),
                id);
    }
}