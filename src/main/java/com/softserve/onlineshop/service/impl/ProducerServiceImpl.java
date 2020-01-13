package com.softserve.onlineshop.service.impl;

import com.softserve.onlineshop.dao.impl.ProducerDaoImpl;
import com.softserve.onlineshop.dao.mapper.ProducerRowMapper;
import com.softserve.onlineshop.dto.ProducerDto;
import com.softserve.onlineshop.dto.mapper.ProducerDtoMapper;
import com.softserve.onlineshop.entity.Producer;
import com.softserve.onlineshop.exception.NotFoundException;
import com.softserve.onlineshop.service.ProducerService;

import java.util.List;
import java.util.stream.Collectors;

public class ProducerServiceImpl implements ProducerService {

    private ProducerDaoImpl producerDao;

    public ProducerServiceImpl() {
        producerDao = new ProducerDaoImpl();
    }

    @Override
    public boolean save(ProducerDto producerDto) {
        Producer producer = new Producer();
        producer.setName(producerDto.getName());
        return producerDao.insert(producer);
    }

    @Override
    public boolean updateById(Long id) {
        return true;
//        return producerDao.updateById(getById(id))
//        return producerDao.updateById(getProducer(getById(id), producerDto));
    }

    private Producer getProducer(Producer producer, ProducerDto producerDto) {
        if (producer == null) {
            producer = new Producer();
        }
        producer.setName(producerDto.getName());
        return producer;
    }

    @Override
    public Producer getById(Long id) {
        return producerDao.getById(new ProducerRowMapper(), id)
                .orElseThrow(() -> new NotFoundException("Producer with id: " + id + " not found"));
    }

    @Override
    public ProducerDto getByIdDto(Long id) {
        return new ProducerDtoMapper().mapToDto(getById(id));
    }

    @Override
    public List<ProducerDto> getAll() {
        List<ProducerDto> producers = producerDao.getAll(new ProducerRowMapper()).stream()
                .map(new ProducerDtoMapper()::mapToDto).collect(Collectors.toList());
        if (producers.isEmpty()) {
            throw new NotFoundException("Users not found");
        }
        return producers;
    }

    @Override
    public boolean deleteById(Long id) {
        return producerDao.deleteById(getById(id).getId());
    }

    public static void main(String[] args) {
        ProducerService producerService = new ProducerServiceImpl();
        System.out.println(producerService.getAll());
//        System.out.println(producerService.updateById(new ProducerDto("NewProducer"), 1L));
    }
}
