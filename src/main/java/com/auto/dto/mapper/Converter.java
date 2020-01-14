package com.auto.dto.mapper;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Converter < T, C > {

    private final Function< T,
                C > fromDto;
    private final Function < C,
            T > fromEntity;

    public Converter(final Function < T, C > fromDto, final Function < C, T > fromEntity) {
        this.fromDto = fromDto;
        this.fromEntity = fromEntity;
    }

    public final C convertFromDto(final T customerDto) {
        return fromDto.apply(customerDto);
    }

    public final T convertFromEntity(final C customer) {
        return fromEntity.apply(customer);
    }

    public final List< C > createFromDtos(final Collection< T > dtoCustomers) {
        return dtoCustomers.stream().map(this::convertFromDto).collect(Collectors.toList());
    }

    public final List < T > createFromEntities(final Collection < C > customers) {
        return customers.stream().map(this::convertFromEntity).collect(Collectors.toList());
    }

}