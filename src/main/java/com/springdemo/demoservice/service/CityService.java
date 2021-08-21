package com.springdemo.demoservice.service;

import com.springdemo.demoservice.model.City;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CityService {
  private List<City> cities = new ArrayList<>(
      Arrays.asList(
        new City("Berlin", "Germany"),
        new City("Paris", "France"),
        new City("London", "UK")
  ));

  public List<City> getAllCities(){
    return cities;
  }

  public City getCity(String cityName){
    return cities.stream().filter(t -> t.getName().equals(cityName)).findFirst().get();
  }

  public void addCity(City newCity){
    cities.add(newCity);
  }

  public void deleteCity(String cityname){
    cities.removeIf(t -> t.getName().equals(cityname));
  }

}
