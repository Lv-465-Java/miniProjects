package com.softserve.onlineshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProducerDto {
    private Long id;
    private String name;

    public ProducerDto(String name) {
        this.name = name;
    }
}
