package com.softserve.onlineshop.dto;

import com.softserve.onlineshop.entity.Producer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModelDto {
    private Long id;
    private String name;
    private Long producerId;
}
