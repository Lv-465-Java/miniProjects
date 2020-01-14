package com.auto.dto;

public class CarDto {
    private Integer id;
    private String brand;
    private String model;
    private String number;
    private String vinCode;
    private Integer year;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public String getVinCode() {
        return vinCode;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarDto(String brand, String model, String number, String vinCode, Integer year) {
        this.brand = brand;
        this.model = model;
        this.number = number;
        this.vinCode = vinCode;
        this.year = year;
    }
    public CarDto(Integer id, String brand, String model, String number, String vinCode, Integer year){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.number = number;
        this.vinCode = vinCode;
        this.year = year;
    }
}