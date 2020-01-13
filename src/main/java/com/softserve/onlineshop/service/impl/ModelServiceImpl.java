package com.softserve.onlineshop.service.impl;

import com.softserve.onlineshop.dao.impl.ModelDaoImpl;
import com.softserve.onlineshop.dao.mapper.ModelRowMapper;
import com.softserve.onlineshop.dto.ModelDto;
import com.softserve.onlineshop.dto.mapper.ModelDtoMapper;
import com.softserve.onlineshop.entity.Model;
import com.softserve.onlineshop.exception.NotFoundException;
import com.softserve.onlineshop.service.ModelService;
import com.softserve.onlineshop.service.ProducerService;

import java.util.List;
import java.util.stream.Collectors;

public class ModelServiceImpl implements ModelService {

    private ModelDaoImpl modelDao;
    private ProducerService producerService;

    public ModelServiceImpl() {
        modelDao = new ModelDaoImpl();
        producerService = new ProducerServiceImpl();
    }

    @Override
    public boolean save(ModelDto modelDto) {
        return modelDao.insert(getModel(null, modelDto));
    }

    @Override
    public boolean updateById(ModelDto modelDto, Long id) {
        return modelDao.updateById(getModel(getById(id), modelDto));
    }

    private Model getModel(Model model, ModelDto modelDto) {
        if (model == null) {
            model = new Model();
        }
        model.setName(modelDto.getName());
        model.setProducerId(producerService.getById(modelDto.getProducerId()).getId());
        return model;
    }

    @Override
    public Model getById(Long id) {
        return modelDao.getById(new ModelRowMapper(), id)
                .orElseThrow(() -> new NotFoundException("Model with id: " + id + " not found"));
    }

    @Override
    public ModelDto getByIdDto(Long id) {
        return new ModelDtoMapper().mapToDto(getById(id));
    }

    @Override
    public List<ModelDto> getAll() {
        List<ModelDto> models = modelDao.getAll(new ModelRowMapper()).stream()
                .map(new ModelDtoMapper()::mapToDto).collect(Collectors.toList());
        if (models.isEmpty()) {
            throw new NotFoundException("Models not found");
        }
        return models;
    }

    @Override
    public List<ModelDto> getAllByProducerId(Long producerId) {
        List<ModelDto> models = modelDao.getAllByProducerId(new ModelRowMapper(), producerId).stream()
                .map(new ModelDtoMapper()::mapToDto).collect(Collectors.toList());
        if (models.isEmpty()) {
            throw new NotFoundException("Models not found");
        }
        return models;
    }

    @Override
    public boolean deleteById(Long id) {
        return modelDao.deleteById(getById(id).getId());
    }

//    public static void main(String[] args) {
//        ModelService modelService = new ModelServiceImpl();
//        System.out.println(modelService.getAllByProducerId(1L));
////        ModelDto modelDto = new ModelDto("6+", 1L);
////        modelDto.setName("6");
////        modelService.updateById(modelDto, 8L);
//    }
}

