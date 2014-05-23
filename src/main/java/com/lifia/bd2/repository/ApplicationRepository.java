package com.lifia.bd2.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lifia.bd2.model.Application;

@Repository
@Transactional
public class ApplicationRepository {
  @Autowired
  private SessionFactory sessionFactory;

  private Session getSession(){
    return sessionFactory.getCurrentSession();
  }
  
  public Application getApp() {
    long id = 1;
    return (Application) getSession().get(Application.class, id);
  }
}
