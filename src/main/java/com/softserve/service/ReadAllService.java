package com.softserve.service;

import java.util.List;

public interface ReadAllService<T> extends CrudService<T> {

    List<T> getAllByUserId(Long id);
}