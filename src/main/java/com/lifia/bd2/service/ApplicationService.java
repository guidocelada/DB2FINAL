package com.lifia.bd2.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lifia.bd2.model.Application;
import com.lifia.bd2.model.Cart;
import com.lifia.bd2.repository.ApplicationRepository;

@Service
@Transactional
public class ApplicationService {
  @Autowired
  private ApplicationRepository appRepository;
  
  public Application getApp() {
    return appRepository.getApp();
  }
  
  public void addCart(Cart cart) {
    getApp().addCart(cart);
  }
  
  public Set<Cart> getCarts() {
    return getApp().getCarts();
  }
  
  public void removeCart(Cart cart) {
    getApp().getCarts().add(cart);
  }
}
