package com.springdemo.demoservice.service;

import com.springdemo.demoservice.model.Programming;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammingRepository extends CrudRepository<Programming, String> {

}
