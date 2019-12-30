package com.softserve.dao;

import java.util.Optional;

public interface CrudDAO<T> {
    Long save(T object);
    ////чи можна повертати звичайний буліан і джаваскріптом діставати айді створеного юзера.

    Optional<T> getById(Long id);

    void update(Long id, T object);

    void delete(Long id);
}