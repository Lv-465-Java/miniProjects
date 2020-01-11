package com.softserve.onlineshop.service;

import com.softserve.onlineshop.dao.mapper.PhoneRowMapper;
import com.softserve.onlineshop.dto.PhoneDto;
import com.softserve.onlineshop.entity.Phone;

import java.util.List;
import java.util.Optional;

public interface PhoneService {

    boolean save(PhoneDto phoneDto);

    Optional<Phone> getById(Long id);

    List<PhoneDto> getByFieldName(String fieldName, String fieldValue);

    List<PhoneDto> getAll();

    boolean updateById(Long id);

    boolean updateByFieldName(String fieldName, String text, String fieldCondition, String textCondition);

    boolean deleteById(Long id);

}
