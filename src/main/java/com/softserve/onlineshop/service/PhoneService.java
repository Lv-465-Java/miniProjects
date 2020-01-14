package com.softserve.onlineshop.service;

import com.softserve.onlineshop.dao.mapper.PhoneRowMapper;
import com.softserve.onlineshop.dto.ModelDto;
import com.softserve.onlineshop.dto.PhoneDto;
import com.softserve.onlineshop.entity.Phone;

import java.util.List;
import java.util.Optional;

public interface PhoneService {

    boolean save(PhoneDto phoneDto);

    Phone getById(Long id);

    PhoneDto getByIdDto(Long id);

    List<PhoneDto> getAll();

//    List<ModelDto> getAllModelId(Long modelId);

    boolean updateById(PhoneDto phoneDto, Long id);

    boolean deleteById(Long id);

}
