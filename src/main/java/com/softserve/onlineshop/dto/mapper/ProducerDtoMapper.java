package com.softserve.onlineshop.dto.mapper;

import com.softserve.onlineshop.dto.ProducerDto;
import com.softserve.onlineshop.entity.Entity;
import com.softserve.onlineshop.entity.Producer;

public class ProducerDtoMapper implements DtoMapper<ProducerDto> {
    @Override
    public ProducerDto mapToDto(Entity entity) {
        Producer producer = (Producer) entity;
        return new ProducerDto(producer.getId(),
                producer.getName());
    }
}
