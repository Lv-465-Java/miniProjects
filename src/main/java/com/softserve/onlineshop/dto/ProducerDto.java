package com.softserve.onlineshop.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ProducerDto {
    private Long id;
    private String name;

    public ProducerDto(String name) {
        this.name = name;
    }
}
