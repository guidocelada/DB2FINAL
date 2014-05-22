package com.lifia.bd2.model;


public class Product {
  @SuppressWarnings("unused")
  private long id; //For hibernate
  private String productId;
  private int quantity;

  protected Product(){} //For hibernate
  
  /**
   * Creates a product with quantity = 1 and productId = productId
   */
  public Product(String productId) {
    this.productId = productId;
    this.quantity = 1;
  }
  
  /**
   * Creates a product with quantity = quantity and productId = productId
   */
  public Product(String productId, int quantity) {
    this.productId = productId;
    this.quantity = quantity;
  }
  
  /**
   * @returns the productId
   */
  public String getProductId() {
    return productId;
  }

  /**
   * @returns the quantity of the product
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Sets the quantity of the product
   */
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  
}
