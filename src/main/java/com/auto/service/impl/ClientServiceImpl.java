package com.auto.service.impl;

import com.auto.dao.impl.ClientDaoImpl;
import com.auto.dto.ClientDto;
import com.auto.dto.mapper.ClientDtoMapper;
import com.auto.model.Client;
import com.auto.service.ClientService;

import java.sql.SQLException;
import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientDaoImpl clientDao = new ClientDaoImpl();
    private ClientDtoMapper clientDtoMapper = new ClientDtoMapper();
    @Override
    public List<Client> findAll()  {
        List<Client> clients = clientDao.getAll();
        return clients;
    }

    @Override
    public Client findById(Integer id) throws SQLException {
        return clientDao.findById(id);
    }

    @Override
    public void create(ClientDto entity) {
        try{
            clientDao.create(clientDtoMapper.convertFromDto(entity));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Client entity) throws SQLException {
    clientDao.update(entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
clientDao.delete(id);
    }
    public Integer getId(){
        int id = 0 ;
        try {
            id = clientDao.getId()+1;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return id;
    }
}
