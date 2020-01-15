package com.softserve.onlineshop.service;

import com.softserve.onlineshop.dto.ProducerDto;
import com.softserve.onlineshop.entity.Producer;

import java.util.List;

public interface ProducerService {

    boolean save(ProducerDto producerDto);

    Producer getById(Long id);

    ProducerDto getByIdDto(Long id);

    List<ProducerDto> getAll();

    boolean updateById(ProducerDto producerDto, Long id);

    boolean deleteById(Long id);

}
