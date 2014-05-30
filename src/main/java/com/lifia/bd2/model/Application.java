package com.lifia.bd2.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Application {
  
  @SuppressWarnings("unused")
  private long id; //For hibernate
  
  private Set<Cart> carts;
  
  private Set<Site> sites;
  
  public Application() {
    this.carts = new HashSet<Cart>();
    this.sites = new HashSet<Site>();
  }
  
  public Set<Cart> getCarts() {
    return carts;
  }

  public void addCart(Cart cart) {
    getCarts().add(cart);
  }
  
  public void removeCart(Cart cart) {
    getCarts().remove(cart);
  }
  
  public Set<Site> getSites() {
    return sites;
  }
  
  public void addSite(Site site) {
    getSites().add(site);
  }
  
  public void removeSite(Site site) {
    getSites().remove(site);
  }
  
  public Site getSiteByToken(String token) {
    for (Site site : getSites())
      if (site.getToken() == token)
        return site;
    return null;
  }
  
  public Site getSiteByName(String name) {
    for (Site site : getSites())
      if (site.getName() == name)
        return site;
    return null;
  }
}
