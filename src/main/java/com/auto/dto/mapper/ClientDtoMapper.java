package com.auto.dto.mapper;

import com.auto.dto.ClientDto;
import com.auto.model.Client;

public class ClientDtoMapper extends Converter<ClientDto, Client> {
    public ClientDtoMapper() {
        super(clientDto -> new Client(clientDto.getId(),clientDto.getName(),clientDto.getTel()),
                client -> new ClientDto(client.getId(),client.getName(),client.getTel()));
    }
}
