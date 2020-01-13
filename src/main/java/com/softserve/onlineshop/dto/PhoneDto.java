package com.softserve.onlineshop.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PhoneDto {
    private Long id;
    private Integer year;
    private Integer price;
    private String photo;
    private String color;
    private Double screenDiagonal;
    private Integer internalMemory;
    private Long modelId;

    public PhoneDto(Integer year, Integer price, String photo, String color, Double screenDiagonal, Integer internalMemory, Long modelId) {
        this.year = year;
        this.price = price;
        this.photo = photo;
        this.color = color;
        this.screenDiagonal = screenDiagonal;
        this.internalMemory = internalMemory;
        this.modelId = modelId;
    }
}
