package com.springdemo.demoservice.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
  @Scheduled(fixedDelay = 3000, initialDelay = 3000)
  public void fixedDelaySch() {
    System.out.println("::Fixed Delay scheduler::");
  }
}
