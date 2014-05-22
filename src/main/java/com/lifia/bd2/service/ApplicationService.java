package com.lifia.bd2.service;

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
  
  public void getCart(Cart cart) {
    getApp().addCart(cart);
  }
}
