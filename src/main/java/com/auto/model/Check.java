package com.auto.model;


public class Check implements BaseEntity{


  private Integer id;
  private String date;
  private Integer idCar;
  private Integer idClient;

  public Check(){

  }

  public Check(Integer id, Integer idCar, Integer idClient, String date) {
    this.id = id;
    this.date = date;
    this.idCar = idCar;
    this.idClient = idClient;
  }

  public Check(Integer idCar, Integer idClient, String date) {
    this.id = id;
    this.date = date;
    this.idCar = idCar;
    this.idClient = idClient;
  }


  public Check(String date) {
  }

  public Check(Integer id, String date) {
    this.id = id;
    this.date = date;
  }

  @Override
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public Integer getIdCar() {
    return idCar;
  }

  public Integer getIdClient() {
    return idClient;
  }

  @Override
  public String toString() {
    return "Check{" +
            "id=" + id +
            ", date='" + date + '\'' +
            ", idCar=" + idCar +
            ", idClinet=" + idClient +
            '}';
  }
}
