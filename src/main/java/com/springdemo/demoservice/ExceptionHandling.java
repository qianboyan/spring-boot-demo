package com.springdemo.demoservice;

import com.springdemo.demoservice.exception.CityException;
import com.springdemo.demoservice.exception.ClubException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
  @ExceptionHandler(value = CityException.class)
  public ResponseEntity<Object> exceptionOfCity(CityException exception) {
    return new ResponseEntity<>("City not found, this is from exception", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = ClubException.class)
  public ResponseEntity<Object> exceptionOfClub(ClubException exception) {
    return new ResponseEntity<>("Club not found, this is from exception", HttpStatus.NOT_FOUND);
  }

}


