package com.auto.model;

public class Client implements BaseEntity{

  private Integer id;
  private String name;
  private Integer tel;

  public Client(Integer id, String name, int tel) {
    this.id = id;
    this.name = name;
    this.tel = tel;
  }

  public Client(String name, Integer tel) {
    this.name = name;
    this.tel = tel;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Integer getTel() {
    return tel;
  }

  @Override
  public String toString() {
    return "Client{" + "id=" + id + ", name='" + name + '\'' + ", tel=" + tel + '}';
    }
}
