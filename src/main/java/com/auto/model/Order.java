package com.auto.model;

public class Order implements BaseEntity{


  private Integer id;
  private Integer checkId;
  private Integer serviceId;

  public Order(Integer id, Integer checkId, Integer serviceId) {
    this.id = id;
    this.checkId = checkId;
    this.serviceId = serviceId;
  }

  @Override
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCheckId() {
    return checkId;
  }

  public void setCheckId(Integer checkId) {
    this.checkId = checkId;
  }

  public Integer getServiceId() {
    return serviceId;
  }

  public void setServiceId(Integer serviceId) {
    this.serviceId = serviceId;
  }

  @Override
  public String toString() {
    return "Order{" +
            "id=" + id +
            ", checkId=" + checkId +
            ", serviceId=" + serviceId +
            '}';
  }
}
