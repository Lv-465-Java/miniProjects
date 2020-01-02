package com.softserve.dao.implementation;

import com.softserve.dao.RecordDAO;
import com.softserve.dao.mapping.RecordMapping;
import com.softserve.database.DataBaseConnection;
import com.softserve.database.JDBCQueries;
import com.softserve.entity.Record;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RecordDAOImpl implements RecordDAO {
    private Connection connection;

    public RecordDAOImpl() {
        this.connection = DataBaseConnection.getInstance().getConnection();
    }

    @Override
    public int save(Record record) {
        return JDBCQueries.update(connection, Record.RecordEntityQueries.INSERT.getQuery(),
                record.getSum(), record.getDate(), record.getNote(), record.getFinancialTypeId(),
                record.getUserId(), record.getCategoryId(), record.getPlanedOutcomeId());
    }

    @Override
    public Optional<Record> getById(Long id) {
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
    public int update(Long id, Record record) {
        return JDBCQueries.update(connection, Record.RecordEntityQueries.UPDATE.getQuery(),
                record.getSum(), record.getDate(), record.getNote(),
                record.getFinancialTypeId(), record.getUserId(), record.getCategoryId(),
                record.getPlanedOutcomeId(), id);
    }

    @Override
    public int delete(Long id) {
        return JDBCQueries.update(connection, Record.RecordEntityQueries.DELETE.getQuery(), id);
    }

    public List<Record> getAllBySelectedFilters(Long userId, Map<String, String> map){
        return JDBCQueries.getListOfObjects(connection, generateSearchQuery(userId, map), new RecordMapping());
    }

    public String generateSearchQuery(Long userId, Map<String, String> parameters) {
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM records WHERE user_id = " + userId);

        try {
            for (Map.Entry<String, String> parameter : parameters.entrySet()) {
                if (parameter.getKey().equals("begin_date")) {
                    stringBuilder.append(" AND date BETWEEN ".concat(parameter.getValue()));
                } else if (parameter.getKey().equals("end_date")) {
                    stringBuilder.append(" AND ".concat(parameter.getValue()));
                } else if (parameter.getKey().equals("financial_type_id")) {
                    stringBuilder.append(" AND financial_type_id = ".concat(parameter.getValue()));
                }
               // LocalDate localDate = LocalDate.now().compareTo()
            }
            return stringBuilder.append(';').toString();
        } catch (RuntimeException e) {
            e.getStackTrace();
            throw new RuntimeException();
        }
    }
}