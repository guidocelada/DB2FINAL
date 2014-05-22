package com.lifia.bd2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifia.bd2.model.Application;
import com.lifia.bd2.repository.ApplicationRepository;

@Service
public class AppService {
  @Autowired
  private ApplicationRepository appRepository;

  public void save() {
      appRepository.save();
  }
  
  public Application getApp() {
    return appRepository.getApp();
  }
}
