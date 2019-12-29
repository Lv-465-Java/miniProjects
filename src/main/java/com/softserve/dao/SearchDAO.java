package com.softserve.dao;

import java.util.List;

public interface SearchDAO<T> extends CrudDAO<T> {
    List<T> getAllByUserId(Long id);
}