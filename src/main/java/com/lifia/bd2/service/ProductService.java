package com.lifia.bd2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lifia.bd2.model.Product;
import com.lifia.bd2.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
  @Autowired
  private ProductRepository productRepository;
  
  public List<Product> getAll() {
      return productRepository.getAll();
  }

  public Product getById(long id) {
      return productRepository.getById(id);
  }

  public void save(Product product) {
      productRepository.save(product);
  }

  public void delete(Product product) {
      productRepository.delete(product);
  }

  public Integer count() {
      return productRepository.count();
  }
}
