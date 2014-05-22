package com.lifia.bd2.model;

import java.util.Collection;


public class Application {
  
  @SuppressWarnings("unused")
  private long id;
  
  private Collection<Cart> carts;
  
  public Collection<Cart> getCarts() {
    return carts;
  }
  
  public void setCarts(Collection<Cart> carts) {
    this.carts = carts;
  }
  
  public void addCart(Cart cart) {
    carts.add(cart);
  }
}
