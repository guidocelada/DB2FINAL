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
	@RequestMapping(value = "/createCart/{site-token}/{user-id}", method = RequestMethod.POST)
	public @ResponseBody String get(@PathVariable("site-token") String siteToken, @PathVariable("user-id") String userId) { 
	  
	//  Cart cart = new Cart(userId, );
	  
	 // appService.addCart(cart);
	  return null;
	} 
	
	
	
	//TODO: 
	//create cart @RequestMapping(value = "/createCart/{site-token}/{user-id}", method = RequestMethod.POST)
	//add 1 qty of product to cart @RequestMapping(value = "addProduct/{cart-token}/{id-product}", method = RequestMethod.POST)
	//add n qty of product to cart @RequestMapping(value = "addProduct/{cart-token}/{id-product}/{quantity}", method = RequestMethod.POST)
	//retrieve qty of product in cart @RequestMapping(value = "getProductQuantity/{cart-token}/{id-product}", method = RequestMethod.GET)
	//retrieve products & qty in cart @RequestMapping(value = "getProducts/{cart-token}", method = RequestMethod.GET)
	//remove 1 qty of product in cart @RequestMapping(value = "removeOneQuantityOfProduct/{cart-token}/{id-product}", method = RequestMethod.DELETE)
	//remove n qty of product in cart @RequestMapping(value = "removeOneQuantityOfProduct/{cart-token}/{id-product}/{quantity}", method = RequestMethod.DELETE)
	//set n as qty of product in cart @RequestMapping(value = "setQuantity/{cart-token}/{id-product}", method = RequestMethod.POST)
	//delete cart @RequestMapping(value = "deleteCart/{cart-token}", method = RequestMethod.DELETE)
}
