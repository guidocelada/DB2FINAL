package com.lifia.bd2.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class Cart {
  @SuppressWarnings("unused")
  private long id; //For hibernate
  
  private String user;
  
  private String token;
  
  private Site site;
  
  private Map<String, Integer> products;
  
  protected Cart() {
    products = new HashMap<String, Integer>();
    this.token = UUID.randomUUID().toString();
  }
  
  public Cart(String user, Site site) {
    this();
    this.user = user;
    this.site = site;
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
  
  public String getToken() {
    return token;
  }
  
  public Site getSite() {
    return site;
  }

}
