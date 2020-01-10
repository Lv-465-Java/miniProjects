package com.softserve.onlineshop.dto.mapper;

import com.softserve.onlineshop.dto.ProducerDto;
import com.softserve.onlineshop.entity.Producer;

public class ProducerDtoMapper {
    public ProducerDto mapToDto(Producer producer) {
        return new ProducerDto(producer.getId(),
                producer.getName());
    }
}
