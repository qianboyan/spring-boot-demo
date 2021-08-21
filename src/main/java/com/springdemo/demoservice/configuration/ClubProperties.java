package com.springdemo.demoservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties("club")
public class ClubProperties {
  private String continental;
  private int centry;

  public String getContinental(){
    return continental;
  }

  public int getCentry(){
    return centry;
  }

  public void setContinental(String continental) {
    this.continental = continental;
  }

  public void setCentry(int centry) {
    this.centry = centry;
  }
}
