package com.lifia.bd2.model;

import java.util.UUID;

public class Site {
  @SuppressWarnings("unused")
  private long id; //For hibernate
  private String name;
  private String token;
  
  protected Site(){}//For hibernate
  
  public Site(String siteName) {
    this.name = siteName;
    //generate token
    this.token = UUID.randomUUID().toString();
  }
  
  public String getName() {
    return name;
  }
  
  public String getToken() {
    return token;
  }

}
