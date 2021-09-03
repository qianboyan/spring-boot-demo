package com.springdemo.demoservice.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.springdemo.demoservice.AbstractTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class ClubServiceControllerTest extends AbstractTest {
  @Override
  @Before
  public void setUp() {
    super.setUp();
  }

  @Test
  public void getClubsList() throws Exception {
    String uri = "/api/club/clubs";
    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
        .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
    int status = mvcResult.getResponse().getStatus();
    assertEquals(200, status);
    String content = mvcResult.getResponse().getContentAsString();
  }

  @Test
  public void deleteProduct() throws Exception {
    String uri = "/api/club/clubs/Dortmund";
    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
    int status = mvcResult.getResponse().getStatus();
    assertEquals(200, status);
  }
}