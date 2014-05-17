package com.lifia.bd2.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lifia.bd2.model.Product;

@Repository
@Transactional
public class ProductRepository {
  @Autowired
  private SessionFactory sessionFactory;
  
  @SuppressWarnings("unchecked")
  public List<Product> getAll() {
      return getSession().createCriteria(Product.class).list();
  }

  public Product getById(long id) {
      return (Product) getSession().get(Product.class, id);
  }

  public void save(Product product) {
      getSession().save(product);
  }

  public void delete(Product product) {
      getSession().delete(product);
  }

  public Integer count() {
      return (Integer) getSession().createCriteria(Product.class)
              .setProjection(Projections.rowCount())
              .uniqueResult();
  }

  private Session getSession(){
      return sessionFactory.getCurrentSession();
  }
}
