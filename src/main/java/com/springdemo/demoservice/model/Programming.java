package com.springdemo.demoservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Programming {
  @Id
  private String name;
  private int ranking;
  private String usage;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRanking() {
    return ranking;
  }

  public void setRanking(int ranking) {
    this.ranking = ranking;
  }

  public String getUsage() {
    return usage;
  }

  public void setUsage(String usage) {
    this.usage = usage;
  }
}
