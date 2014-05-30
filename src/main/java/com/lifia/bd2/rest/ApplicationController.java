package com.lifia.bd2.rest;

import com.lifia.bd2.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifia.bd2.service.ApplicationService;

@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService appService;

    /**
     * Creates a token for the cart
     *
     * @returns the token of the cart that it's later used for cart operations
     */
    @RequestMapping(value = "/createCart/{site-token}/{user-id}", method = RequestMethod.POST)
    public @ResponseBody
    String createCart(@PathVariable("site-token") String siteToken, @PathVariable("user-id") String userId) {
        return appService.createCart(siteToken, userId).getToken();
    }

    /**
     * Registers a site or returns the token for the site
     *
     * @returns the token of the site (existing or new site)
     */
    @RequestMapping(value = "registerSite/{site-name}", method = RequestMethod.POST)
    public @ResponseBody
    String getSiteToken(@PathVariable("site-name") String siteName) {
        return appService.createSite(siteName).getToken();
    }

    /**
     * Adds a product to the cart (quantity = n)
     */
    @RequestMapping(value = "addProduct/{cart-token}/{id-product}/{quantity}", method = RequestMethod.POST)
    public @ResponseBody
    void addProductWithQuantity(@PathVariable("cart-token") String cartToken, @PathVariable("id-product") String idProduct, @PathVariable("quantity") int quantity) {
        appService.addProductToCart(cartToken, idProduct, quantity);
    }

    /**
     * Adds a product to the cart (quantity = 1)
     */
    @RequestMapping(value = "addProduct/{cart-token}/{id-product}", method = RequestMethod.POST)
    public @ResponseBody
    void addOneProduct(@PathVariable("cart-token") String cartToken, @PathVariable("id-product") String idProduct) {
        appService.addProductToCart(cartToken, idProduct, 1);
    }

    /**
     * Deletes a Cart if exists
     */
    @RequestMapping(value = "deleteCart/{cart-token}", method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteCart(@PathVariable("cart-token") String cartToken) {
        appService.deleteCart(cartToken);
    }

    /**
     * Retrieve quantity of product in cart
     *
     * @returns the quantity of the product in the cart
     */
    @RequestMapping(value = "getProductQuantity/{cart-token}/{id-product}", method = RequestMethod.GET)
    public @ResponseBody
    Integer getProductQuantity(@PathVariable("cart-token") String cartToken, @PathVariable("id-product") String idProduct) {
        return appService.getProductQuantity(cartToken, idProduct);
    }

    /**
     * Removes qty=1 product in cart When product's quantity reach 0, product is
     * deleted from cart
     *
     * @returns whether it was possible or not
     */
    @RequestMapping(value = "removeQuantityOfProduct/{cart-token}/{id-product}", method = RequestMethod.DELETE)
    public @ResponseBody
    boolean removeQuantityOfProduct(@PathVariable("cart-token") String cartToken, @PathVariable("id-product") String idProduct) {
        int current = appService.getProductQuantity(cartToken, idProduct);
        if (current < 1) {
            return false;
        }
        appService.setQuantity(cartToken, idProduct, current - 1);
        return true;
    }

    /**
     * Remove n qty of product in cart When product's quantity reach 0, product
     * is deleted from cart
     *
     * @returns whether it was possible or not
     */
    @RequestMapping(value = "removeQuantityOfProduct/{cart-token}/{id-product}/{quantity}", method = RequestMethod.DELETE)
    public @ResponseBody
    boolean removeQuantityOfProduct(@PathVariable("cart-token") String cartToken, @PathVariable("id-product") String idProduct, @PathVariable("quantity") Integer qty) {
        int current = appService.getProductQuantity(cartToken, idProduct);
        if (qty > current) {
            return false;
        }
        appService.setQuantity(cartToken, idProduct, current - qty);
        return true;
    }

    /**
     * Set n as qty of a product in cart, When product's quantity reach 0,
     * product is deleted from cart
     */
    @RequestMapping(value = "setQuantity/{cart-token}/{id-product}/{quantity}", method = RequestMethod.POST)
    public @ResponseBody
    void setQuantity(@PathVariable("cart-token") String cartToken, @PathVariable("id-product") String idProduct, @PathVariable("quantity") Integer qty) {
        appService.setQuantity(cartToken, idProduct, qty);
    }

    /**
     * Adds a product to the cart (quantity = 1)
     */
    @RequestMapping(value = "deleteProduct/{cart-token}/{id-product}", method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteProduct(@PathVariable("cart-token") String cartToken, @PathVariable("id-product") String idProduct) {
        appService.setQuantity(cartToken, idProduct, 0);
    }

    /**
     * Retrieves the cart
     * @returns the full cart
     */
    @RequestMapping(value = "getCart/{cart-token}", method = RequestMethod.GET)
    public @ResponseBody
    Cart getCart(@PathVariable("cart-token") String cartToken) {
        return appService.getCart(cartToken);
    }
}
