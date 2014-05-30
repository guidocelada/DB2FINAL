package com.lifia.bd2.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lifia.bd2.model.Application;
import com.lifia.bd2.model.Cart;
import com.lifia.bd2.model.Site;
import com.lifia.bd2.repository.ApplicationRepository;

@Service
@Transactional
public class ApplicationService {
  @Autowired
  private ApplicationRepository appRepository;
  
  public Application getApp() {
    return appRepository.getApp();
  }
  
  public Cart createCart(String siteToken, String userId) {
    Application app = getApp();
    Site site = app.getSiteByToken(siteToken);   
    Cart cart = new Cart(userId, site);
    app.addCart(cart); 
    return cart;
  }
  
  public Site createSite(String siteName) {
    Application app = getApp();
    Site site = app.getSiteByName(siteName);
    if (site == null)
      site = new Site(siteName);
    app.addSite(site);
    return site;
  }
  
  public void addProductToCart(String cartToken, String productId, int quantity) {
    Application app = getApp();
    Cart cart = app.getCartByToken(cartToken);
    if (cart != null)
      cart.addProduct(productId, quantity);
  }
  
  public void deleteCart(String cartToken) {
    Application app = getApp();
    Cart cart = app.getCartByToken(cartToken);
    if (cart != null)
      app.removeCart(cart);
  }
  
  public int getProductQuantity(String cartToken, String productId) {
    Application app = getApp();
    Cart cart = app.getCartByToken(cartToken);
    if (cart != null)
      return cart.getProductQuantity(productId);
    return 0;
  }

  public void setQuantity(String cartToken, String idProduct, int i) {
    Application app = getApp();
    Cart cart = app.getCartByToken(cartToken);
    if (cart != null)
      cart.setProduct(idProduct, i);
  }
   
  public Cart getCart(String cartToken) {
    Application app = getApp();
    Cart cart = app.getCartByToken(cartToken);
    Hibernate.initialize(cart.getProducts());
    return cart;
  }
  
  public void removeProduct(String cartToken, String productId) {
    Application app = getApp();
    Cart cart = app.getCartByToken(cartToken);
    if (cart != null)
      cart.removeProduct(productId);
  }
  
}
