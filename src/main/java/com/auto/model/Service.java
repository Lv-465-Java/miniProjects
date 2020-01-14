package com.auto.model;

public class Service implements BaseEntity{

  private Integer id;
  private String name;
  private Double price;

  public Service(Integer id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Service{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + '}';
  }
}
