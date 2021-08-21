package com.springdemo.demoservice.controller;

import com.springdemo.demoservice.model.Programming;
import com.springdemo.demoservice.service.ProgrammingRepository;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/programming")
@Api(value = "apis for programmings")
public class ProgrammingController {

  @Autowired
  private ProgrammingRepository programmingRepository;

  @GetMapping("/programs")
  public List<Programming> showProgramming() {
    List<Programming> programmings = new ArrayList<>();
    programmingRepository.findAll().forEach(programmings::add);
    return programmings;
  }

  @GetMapping("/programs/{name}")
  public Optional<Programming> getOneProgram(@PathVariable("name") String name){
    return programmingRepository.findById(name);
  }

  @PostMapping(value = "/programs")
  public void addProgram(@RequestBody Programming programming) {
    programmingRepository.save(programming);
  }

  @PutMapping("/programs/{name}")
  public void updateClubList(@PathVariable("name") String name, @RequestBody Programming programming){
    programmingRepository.save(programming);
  }

  @DeleteMapping("/programs/{name}")
  public void deleteClub(@PathVariable("name") String name){
    programmingRepository.deleteById(name);
  }

}
