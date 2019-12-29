package com.softserve.dao;

import com.softserve.entity.Record;

import java.util.List;

public interface RecordDAO extends SearchDAO<Record> {
    List<Record> getAllByUserIdAndFinancialTypeId(Long userId, Long typeId);
}