package com.auto.dto;

public class CheckDto {
    private Integer id;
    private Integer idCar;
    private Integer idClient;
    private String date;

    public CheckDto(String date) {
        this.date = date;
    }

    public CheckDto(Integer idCar, Integer idClient, String date) {
        this.idCar = idCar;
        this.idClient = idClient;
        this.date = date;
    }

    public CheckDto(Integer id, Integer idCar, Integer idClient, String date) {
        this.id = id;
        this.idCar = idCar;
        this.idClient = idClient;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCar() {
        return idCar;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "CheckDto{" +
                "idCar=" + idCar +
                ", idClient=" + idClient +
                ", date='" + date + '\'' +
                '}';
    }
}
