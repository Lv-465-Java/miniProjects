package com.softserve.dao.implementation;

import com.softserve.dao.RecordDAO;

import com.softserve.dao.mapping.RecordMapping;
import com.softserve.database.DataBaseConnection;
import com.softserve.database.JDBCQueries;
import com.softserve.entity.Record;
import com.softserve.exception.NoSuchEntityException;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class RecordDAOImpl implements RecordDAO<Record> {
    private Connection connection;

    public RecordDAOImpl() {
        this.connection = DataBaseConnection.getInstance().getConnection();
    }

    @Override
    public boolean save(Record record) {
        return JDBCQueries.update(connection, Record.RecordEntityQueries.INSERT.getQuery(),
                record.getSum(), record.getDate(), record.getNote(), record.getFinancialTypeId(),
                record.getUserId(), record.getCategoryId(), record.getPlanedOutcomeId());
    }

    @Override
    public Optional<Record> getById(Long id) throws NoSuchEntityException {
        return JDBCQueries.getObject(connection, Record.RecordEntityQueries.GET_BY_ID.getQuery(),
                new RecordMapping(), id);
    }

    @Override
    public List<Record> getAllByUserIdAndFinancialTypeId(Long userId, Long typeId) {
        return JDBCQueries.getListOfObjects(connection, Record.RecordEntityQueries.GET_ALL_BY_USER_ID_AND_FINANCIAL_TYPE.getQuery(),
                new RecordMapping(), userId, typeId);
    }

    @Override
    public List<Record> getAllByUserId(Long id) {
        return JDBCQueries.getListOfObjects(connection, Record.RecordEntityQueries.GET_ALL_BY_USER_ID.getQuery(),
                new RecordMapping(), id);
    }

    @Override
    public boolean update(Long id, Record record) {
        return JDBCQueries.update(connection, Record.RecordEntityQueries.UPDATE.getQuery(),
                record.getSum(), record.getDate(), record.getNote(),
                record.getFinancialTypeId(), record.getUserId(), record.getCategoryId(),
                record.getPlanedOutcomeId(), id);
    }

    @Override
    public boolean delete(Long id) {
        return JDBCQueries.update(connection, Record.RecordEntityQueries.DELETE.getQuery(), id);
    }

    public List<Record> getAllBySelectedFilters(Long userId, Object... parameters) {
        return JDBCQueries.getListOfObjects(connection, generateSearchQuery(userId, parameters), new RecordMapping(), parameters);
    }

    public String generateSearchQuery(Long userId, Object... parameters) {
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM records WHERE user_id = ".concat(userId.toString()));

        try {
            for (Object parameter : parameters) {

                if (parameter instanceof Long) {
                    stringBuilder.append(" AND financial_type_id = ?");
                }
                if (parameter instanceof LocalDate) {
                    if (!stringBuilder.toString().contains("date BETWEEN")) {
                        stringBuilder.append(" AND date BETWEEN ?");
                    } else {
                        stringBuilder.append(" AND ?");
                    }
                }
            }
            return stringBuilder.append(";").toString();
        } catch (RuntimeException e) {
            e.getStackTrace();
            throw new RuntimeException();
        }
    }
}