package com.lifia.bd2.model;

import java.util.Collection;


public class Cart {
  @SuppressWarnings("unused")
  private long id;
  
  private String user;
  
  private Collection<Product> products;

  public Collection<Product> getProducts() {
    return products;
  }

  public void setProducts(Collection<Product> products) {
    this.products = products;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

}
