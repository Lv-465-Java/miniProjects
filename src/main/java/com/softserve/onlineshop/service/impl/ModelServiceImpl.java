package com.softserve.onlineshop.service.impl;

import com.softserve.onlineshop.dao.impl.ModelDaoImpl;
import com.softserve.onlineshop.dto.ModelDto;
import com.softserve.onlineshop.entity.Model;
import com.softserve.onlineshop.service.ModelService;
import com.softserve.onlineshop.service.ProducerService;

import java.util.List;

public class ModelServiceImpl implements ModelService {

    private ModelDaoImpl modelDao;
    private ProducerService producerService;

    public ModelServiceImpl() {
        modelDao = new ModelDaoImpl();
        producerService = new ProducerServiceImpl();
    }

    @Override
    public boolean save(ModelDto modelDto) {
        return true;
    }

    @Override
    public boolean updateById(ModelDto modelDto, Long id) {
        return false;
    }

//    private Model getModel(Model model, ModelDto modelDto) {
//        if (model == null) {
//            model = new Model();
//        }
//        model.setName(modelDto.getName());
////        model.setProducerId(producerService.
//    }

    @Override
    public Model getById(Long id) {
        return null;
    }

    @Override
    public ModelDto getByIdDto(Long id) {
        return null;
    }

    @Override
    public List<ModelDto> getAll() {
        return null;
    }

    @Override
    public List<ModelDto> getAllByProducerId(Long producerId) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
