package com.lifia.bd2.model;


public class Product {
  @SuppressWarnings("unused")
  private long id;
  
  private String productId;
  
  private int quantity;

  protected Product(){} //For hibernate
  
  public Product(String productId) {
    this.productId = productId;
    this.quantity = 1;
  }
  
  public Product(String productId, int quantity) {
    this.productId = productId;
    this.quantity = quantity;
  }
  
  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  
}
