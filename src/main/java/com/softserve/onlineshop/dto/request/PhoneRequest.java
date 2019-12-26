package com.softserve.onlineshop.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneRequest {

    private Integer year;
    private Integer price;
    private String photo;
    private String color;
    private Double screenDiagonal;
    private Integer internalMemory;
    private Long modelId;
}