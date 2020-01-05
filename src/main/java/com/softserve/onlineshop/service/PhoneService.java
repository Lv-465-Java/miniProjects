package com.softserve.onlineshop.service;

import com.softserve.onlineshop.dao.CrudDao;
import com.softserve.onlineshop.dto.PhoneDto;
import com.softserve.onlineshop.entity.Phone;

import java.util.List;
import java.util.Optional;

public interface PhoneService {

    boolean insert(PhoneDto phoneDto);

    Optional<Phone> getById(Long id);

    List<Phone> getByFieldName(String fieldName, String fieldValue);

    List<Phone> getAll();

    boolean updateById(String... args);

    boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition);

    boolean deleteById(Long id);

}
