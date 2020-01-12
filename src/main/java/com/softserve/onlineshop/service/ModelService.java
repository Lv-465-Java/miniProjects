package com.softserve.onlineshop.service;

import com.softserve.onlineshop.dto.ModelDto;
import com.softserve.onlineshop.entity.Model;

import java.util.List;

public interface ModelService {

    boolean save(ModelDto modelDto);

    Model getById(Long id);

    ModelDto getByIdDto(Long id);

    List<ModelDto> getAll();

    List<ModelDto> getAllByProducerId(Long producerId);

    boolean updateById(ModelDto modelDto, Long id);

    boolean deleteById(Long id);

}
