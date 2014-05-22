package com.lifia.bd2.model;

import java.util.HashSet;
import java.util.Set;


public class Application {
  
  @SuppressWarnings("unused")
  private long id; //For hibernate
  
  private Set<Cart> carts;
  
  public Application() {
    this.carts = new HashSet<Cart>();
  }
  
  public Set<Cart> getCarts() {
    return carts;
  }

  public void addCart(Cart cart) {
    getCarts().add(cart);
  }
  
  public void removeCart(Cart cart) {
    getCarts().remove(cart);
  }
}
