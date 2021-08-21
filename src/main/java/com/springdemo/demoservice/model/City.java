package com.springdemo.demoservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about a city")
public class City {
  @ApiModelProperty(notes = "the name of the city")
  public String name;
  @ApiModelProperty(notes = "where the city located")
  public String country;

  public City(String name, String country) {
    this.name = name;
    this.country = country;
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
}
