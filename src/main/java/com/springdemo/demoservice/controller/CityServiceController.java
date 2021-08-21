package com.springdemo.demoservice.controller;

import com.springdemo.demoservice.model.City;
import com.springdemo.demoservice.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/city")
@Api(value = "apis for cities")
public class CityServiceController {
  @Autowired
  private CityService cityService;

  @RequestMapping(method = RequestMethod.GET)
  public String helloWorld() {
    return "Index of Cities from CityService";
  }

  @GetMapping("/about")
  @ApiOperation(value = "meta information")
  public String showUserInfo() {
    return "This is a Service using Macbook. DummyInfo";
  }

  @RequestMapping(method = RequestMethod.GET, value = "/cities")
  @ApiOperation(value = "list all cities we have", notes = "feel free to add new cities")
  public List<City> listAllCities() {
    return cityService.getAllCities();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/cities/{cityname}")
  @ApiOperation(value = "get a single city", notes = "get city")
  @ApiResponses({@ApiResponse(code = 200, message = "Return cities name from model.")})
  public City getOneCity(@ApiParam(value = "add a city name", required = true) @PathVariable("cityname") String cityname) {
    return cityService.getCity(cityname);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/cities")
  @ApiOperation(value = "put a new city to list", notes = "feel free to add new cities")
  public void addOneCity(@ApiParam(value = "please add a city class", required = true) @RequestBody City city) {
    cityService.addCity(city);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/cities/{cityname}")
  @ApiOperation(value = "delete a city from list", notes = "feel free to delete cities")
  public void deleteOneCity(@ApiParam(value = "remove one city", required = true) @PathVariable String cityname) {
    cityService.deleteCity(cityname);
  }

  // load properties from yaml file
  @Value("${demoprops.title}")
  private String title;
  @Value("${demoprops.date}")
  private String date;

  @GetMapping("/properties")
  @ApiOperation(value = "get properties from yaml file")
  public String getProps() {
    return title + date;
  }

  @GetMapping("/failtest")
  public ResponseEntity<Object> failTest(){
    if(true)throw new CityException();
    // return will never be used
    return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
  }

}
