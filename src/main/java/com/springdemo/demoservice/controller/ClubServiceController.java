package com.springdemo.demoservice.controller;

import com.springdemo.demoservice.configuration.ClubProperties;
import com.springdemo.demoservice.exception.ClubException;
import com.springdemo.demoservice.model.Club;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/club")
@Api(value = "apis for clubs")
public class ClubServiceController {
  @Autowired
  ClubProperties myClubProperties;

  @Autowired
  RestTemplate restTemplate;

  private static Map<String, Club> clubMap = new HashMap<>();
  static {
    Club bayern = new Club("Bayern", "DE", "Munich", 1);
    Club dortmund = new Club("Dortmund", "DE", "Dortmund", 2);
    clubMap.put(bayern.getName(), bayern);
    clubMap.put(dortmund.getName(), dortmund);
  }

  @GetMapping("/clubs")
  public ResponseEntity<Object> showClub() {
    return new ResponseEntity<>(clubMap.values(), HttpStatus.OK);
  }

  @PostMapping("/clubs")
  public ResponseEntity<Object> addClub(@RequestBody Club club) {
    clubMap.put(club.getName(), club);
    return new ResponseEntity<>("Club has been added", HttpStatus.OK);
  }

  @PutMapping("/clubs/{name}")
  public ResponseEntity<Object> updateClubList(@PathVariable("name") String name, @RequestBody Club club){
    clubMap.remove(name);
    clubMap.put(club.getName(), club);
    return new ResponseEntity<>("Club list hat been updated", HttpStatus.OK);
  }

  @DeleteMapping("/clubs/{name}")
  public ResponseEntity<Object> deleteClub(@PathVariable("name") String name){
    if (!clubMap.containsKey(name)){
      throw new ClubException();
    };
    clubMap.remove(name);
    return new ResponseEntity<>("Club has been deleted", HttpStatus.OK);
  }

  @GetMapping("/properties")
  @ApiOperation(value = "get properties from config props")
  public String getProps() {
    return myClubProperties.getContinental();
  }

  @GetMapping("/template/clubs")
  public String getClubsUsingTemplate(){
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity <String> entity = new HttpEntity<String>(headers);
    return restTemplate.exchange("http://localhost:9090/api/club/clubs", HttpMethod.GET, entity, String.class).getBody();
  }

  @PostMapping("/template/clubs")
  public String postClubUsingTemplate(@RequestBody Club club){
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<Club> entity = new HttpEntity<Club>(club, headers);
    return restTemplate.exchange("http://localhost:8080/products", HttpMethod.POST, entity, String.class).getBody();
  }

}
