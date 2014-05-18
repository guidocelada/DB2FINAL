package com.lifia.bd2.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifia.bd2.model.Product;
import com.lifia.bd2.service.ProductService;

@Controller
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/get/{product-id}", method = RequestMethod.GET)
	public @ResponseBody Product get(@PathVariable("location-id") long id) { //FIXME
		return productService.getById(id);
	}
	
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public @ResponseBody List<Product> list() {
	  return productService.getAll();
  }
	
	//TODO add other methods such as delete, etc
	
}
