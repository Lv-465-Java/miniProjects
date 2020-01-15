package com.softserve.onlineshop.dto.mapper;

import com.softserve.onlineshop.dto.ModelDto;
import com.softserve.onlineshop.entity.Model;

public class ModelDtoMapper {
    public ModelDto mapToDto(Model model) {
        ModelDto modelDto = new ModelDto();
        modelDto.setId(model.getId());
        modelDto.setName(model.getName());
        modelDto.setProducerId(model.getProducerId());
        return modelDto;
    }
}
