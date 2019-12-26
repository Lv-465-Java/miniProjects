package com.softserve.onlineshop.dto.response;

import com.softserve.onlineshop.entity.Model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelResponse {

    private Long id;
    private String name;
    private ProducerResponse producerResponse;

    public ModelResponse(Model model) {
        id = model.getId();
        name = model.getName();
//        producerResponse = new ProducerResponse(model.getProducer());
    }
}
