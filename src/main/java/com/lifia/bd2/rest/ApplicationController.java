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
	
	/**
	 * Creates a token for the cart 
	 * @returns the token of the cart that it's later used for cart operations
	 */
	@RequestMapping(value = "/createCart/{site-token}/{user-id}", method = RequestMethod.GET)
	public @ResponseBody String get(@PathVariable("site-token") String siteToken, @PathVariable("user-id") String userId) { 
	  
	//  Cart cart = new Cart(userId, );
	  
	 // appService.addCart(cart);
	  return null;
	} 
	
	
	
	//TODO: 
	//create cart
	//add 1 qty of product to cart
	//add n qty of product to cart
	//retrieve qty of product in cart
	//retrieve products & qty in cart
	//remove 1 qty of product in cart
	//remove n qty of product in cart
	//set n as qty of product in cart
	//delete cart
}
