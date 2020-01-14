package com.auto.dto;

public class ClientDto {
    private Integer id;
    private String name;
    private Integer tel;

    public ClientDto(String name, Integer tel) {
        this.name = name;
        this.tel = tel;
    }

    public ClientDto(Integer id, String name, Integer tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getTel() {
        return tel;
    }
}
