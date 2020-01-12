package com.softserve.onlineshop.dto;

import com.softserve.onlineshop.entity.Producer;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ModelDto {
    private Long id;
    private String name;
    private Long producerId;
}
