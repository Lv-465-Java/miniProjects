package com.softserve.service;

import com.softserve.entity.FinancialType;

import java.util.List;

public interface ReadAllService<T> extends CrudService<T> {

    List<T> getAllByUserId(Long id);

    List<FinancialType> getTypes();
}