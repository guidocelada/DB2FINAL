package com.lifia.bd2.model;


public class Product {
  private long id;
  private String name;
  private int stock;
  private int price;
  private String description;
  
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getStock() {
    return stock;
  }
  
  public void setStock(int stock) {
    this.stock = stock;
  }
  
  public int getPrice() {
    return price;
  }
  
  public void setPrice(int price) {
    this.price = price;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
}
