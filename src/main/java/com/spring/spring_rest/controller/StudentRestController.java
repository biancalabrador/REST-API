package com.spring.spring_rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_rest.entity.Student;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/api")
public class StudentRestController {
  
  private List<Student> theStudents;

  @PostConstruct 
  public void initialize() {
    theStudents = new ArrayList<>();
    theStudents.add(new Student("Ada", "Wong"));
    theStudents.add(new Student("Mikasa", "Ackerman"));
    theStudents.add(new Student("Rukia", "Kuchiki"));
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
      return theStudents;
  }
  

}
