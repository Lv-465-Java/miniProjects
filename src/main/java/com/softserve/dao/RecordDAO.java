package com.softserve.dao;

import java.util.List;

public interface RecordDAO<T> extends SearchDAO<T> {
    List<T> getAllByUserIdAndFinancialTypeId(Long userId, Long typeId);
}