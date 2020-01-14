package com.auto.model;

public class Car implements BaseEntity {

    private Integer id;
    private String brand;
    private String model;
    private String number;
    private String vinCode;
    private Integer year;

    public Car(){

    }

    public Car(Integer id,String brand, String model, String number, String vinCode, Integer year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.number = number;
        this.vinCode = vinCode;
    }
    public Car(String brand, String model, String number, String vinCode, Integer year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.number = number;
        this.vinCode = vinCode;
    }


    @Override
    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public String getNumber() {
        return number;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", vinCode='" + vinCode + '\'' +
                ", year=" + year +
                '}';
    }

}
