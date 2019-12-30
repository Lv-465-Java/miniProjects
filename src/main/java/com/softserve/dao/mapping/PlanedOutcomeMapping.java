package com.softserve.dao.mapping;

import com.softserve.entity.PlanedOutcome;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanedOutcomeMapping implements Mapping<PlanedOutcome> {

    @Override
    public PlanedOutcome mapDataBaseRow(ResultSet resultSet) {
        PlanedOutcome planedOutcome = new PlanedOutcome();

        try {
            planedOutcome.setId(resultSet.getLong("id"));
            planedOutcome.setSum(resultSet.getDouble("sum"));
            planedOutcome.setDate(resultSet.getTimestamp("date").toLocalDateTime().toLocalDate());
            planedOutcome.setNote(resultSet.getString("note"));
            planedOutcome.setUserId(resultSet.getLong("user_id"));
            planedOutcome.setCategoryId(resultSet.getLong("category_id"));
            return planedOutcome;
        } catch (SQLException e) {
            e.getStackTrace();
            throw new RuntimeException();
        }
    }
}
