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
  
  
  /**
   * Creates a cart with an unique token.
   */
  protected Cart() {
    products = new HashMap<String, Integer>();
    this.token = UUID.randomUUID().toString();
  }
  
  /**
   * Creates a cart with a user and a site assigned.
   * The cart will have an unique token.
   */
  public Cart(String user, Site site) {
    this();
    this.user = user;
    this.site = site;
  }

  /**
   * @returns the products in the cart
   */
  public Map<String, Integer> getProducts() {
    return products;
  }

  /**
   * Adds a product to the cart with the specified quantity.
   * If the product exists, it will add the quantity to the existing quantity for that product
   * The minimum quantity is 1
   */
  public void addProduct(String productId, int quantity) {
    if (quantity <= 0)return;
    
    if (this.containsProduct(productId))
        this.setProduct(productId, products.get(productId) + quantity);
    else
        products.put(productId, quantity);
  }
  
  /**
   * Sets the quantity of the product from the cart
   * If quantity equals 0, the product will be removed from the cart
   */
  public void setProduct(String productId,int quantity){
      if(quantity<0)return;
      if(quantity==0)removeProduct(productId);
      products.put(productId,quantity);
  }
  
  /**
   * Removes the product from the cart
   */
  public void removeProduct(String productId) {
    if (this.containsProduct(productId))
      products.remove(productId);
  }
  
  /**
   * @returns if the cart contains the specified product
   */
  public boolean containsProduct(String productId) {
    return products.containsKey(productId);
  }

  /**
   * @returns the user for the cart
   */
  public String getUser() {
    return user;
  }
  
  /**
   * @returns the cart unique token
   */
  public String getToken() {
    return token;
  }
  
  /**
   * @returns the site for the cart
   */
  public Site getSite() {
    return site;
  }

  /**
   * @returns the quantity in the cart for the specified product
   */
  public int getProductQuantity(String productId) {
    if (products.containsKey(productId))
      return products.get(productId);
    return 0;
  }


}
