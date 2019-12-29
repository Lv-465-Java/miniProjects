package com.softserve.dao.implementation;

import com.softserve.dao.RecordDAO;
import com.softserve.entity.Record;

import java.util.List;
import java.util.Optional;

public class RecordDAOImpl implements RecordDAO {
    @Override
    public List<Record> getAllByUserIdAndFinancialTypeId(Long userId, Long typeId) {
        return null;
    }

    @Override
    public List<Record> getAllByUserId(Long id) {
        return null;
    }

    @Override
    public Long save(Record record) {
        return null;
    }

    @Override
    public Optional<Record> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Record object, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}