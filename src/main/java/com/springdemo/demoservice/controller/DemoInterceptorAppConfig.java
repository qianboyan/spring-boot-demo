package com.springdemo.demoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class DemoInterceptorAppConfig implements WebMvcConfigurer {

  @Autowired
  DemoInterceptor cityInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(cityInterceptor);
  }
}
