package com.springdemo.demoservice.model;

public class Club {
  public String name;
  public String country;
  public String city;
  public int ranking;

  public Club(String name, String country, String city, int ranking) {
    this.name = name;
    this.country = country;
    this.city = city;
    this.ranking = ranking;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public int getRanking() {
    return ranking;
  }

  public void setRanking(int ranking) {
    this.ranking = ranking;
  }
}
