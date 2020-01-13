package com.softserve.onlineshop.dto.mapper;

import com.softserve.onlineshop.dto.ModelDto;
import com.softserve.onlineshop.entity.Model;

public class ModelDtoMapper {
    public ModelDto mapToDto(Model model) {
        return new ModelDto(model.getId(),
                model.getName(),
                model.getProducerId());
    }
}
