package com.softserve.onlineshop.dto.mapper;

import com.softserve.onlineshop.entity.Entity;

public interface DtoMapper<TEntity> {
    TEntity mapToDto(Entity entity);
}
