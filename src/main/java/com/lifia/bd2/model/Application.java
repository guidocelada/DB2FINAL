package com.lifia.bd2.model;

import java.util.Collection;


public class Application {
  
  @SuppressWarnings("unused")
  private long id; //For hibernate
  
  private Collection<Cart> carts;
  
  public Collection<Cart> getCarts() {
    return carts;
  }

  public void addCart(Cart cart) {
    carts.add(cart);
  }
  
  public void removeCart(Cart cart) {
    carts.add(cart);
  }
}
