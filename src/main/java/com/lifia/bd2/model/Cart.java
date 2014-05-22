package com.lifia.bd2.model;

import java.util.HashMap;
import java.util.Map;


public class Cart {
  @SuppressWarnings("unused")
  private long id; //For hibernate
  
  private String user;
  
  private Map<String, Integer> products;
  
  protected Cart() {
    products = new HashMap<String, Integer>();
  }
  
  public Cart(String user) {
    this();
    this.user = user;
  }

  public Map<String, Integer> getProducts() {
    return products;
  }

  public void addProduct(String productId) {
    if (products.containsKey(productId))
      products.put(productId, products.get(productId) + 1);
    else
      products.put(productId, 1);
  }

  public String getUser() {
    return user;
  }

}
