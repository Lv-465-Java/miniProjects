package com.softserve.onlineshop.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDto {
    private Long id;
    private Integer year;
    private Integer price;
    private String photo;
    private String color;
    private Double screenDiagonal;
    private Integer internalMemory;
    private Long modelId;
}
