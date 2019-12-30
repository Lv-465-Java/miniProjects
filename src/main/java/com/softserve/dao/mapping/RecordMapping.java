package com.softserve.dao.mapping;

import com.softserve.entity.Record;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordMapping implements Mapping<Record> {

    @Override
    public Record mapDataBaseRow(ResultSet resultSet) {
        Record record = new Record();

        try {
            record.setId(resultSet.getLong("id"));
            record.setSum(resultSet.getDouble("sum"));
            record.setDate(resultSet.getTimestamp("date").toLocalDateTime().toLocalDate());
            record.setNote(resultSet.getString("note"));
            record.setFinancialTypeId(resultSet.getLong("financial_type_id"));
            record.setCategoryId(resultSet.getLong("category_id"));
            record.setUserId(resultSet.getLong("user_id"));
            record.setPlanedOutcomeId(resultSet.getLong("planed_outcome_id"));
            return record;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}