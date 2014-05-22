package com.lifia.bd2.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifia.bd2.model.Cart;
import com.lifia.bd2.service.ApplicationService;

@Controller
public class ApplicationController {
	
  //private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);
  
	@Autowired
	private ApplicationService appService;
	
	/*
	@RequestMapping(value = "/get/{product-id}", method = RequestMethod.GET)
	public @ResponseBody Product get(@PathVariable("product-id") long id) { 
		return productService.getById(id);
	} */
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String test() {
	  Cart[] carts = (Cart[]) appService.getApp().getCarts().toArray();
	  
	  return carts[1].getUser();
	}
	
}
