package com.spring.spring_rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.service.StudentService;

import jakarta.validation.Valid;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/api/students")
public class StudentRestController {
  
  private StudentService studentService;

  public StudentRestController(StudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping 
  public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto theStudentDto) {
    StudentDto saved = studentService.createStudent(theStudentDto);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
  }

  @GetMapping("{id}")
  public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
    StudentDto studentDto = studentService.getStudentById(id);
    return ResponseEntity.ok(studentDto);
  }

  @GetMapping 
  public ResponseEntity<List<StudentDto>> getAllStudents() {
    List<StudentDto> students = studentService.getAllStudents();
    return ResponseEntity.ok(students);
  }

  @PutMapping("{id}")
  public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentDto thStudentDto) {
    StudentDto studentDto = studentService.updateStudent(id, thStudentDto);
    return ResponseEntity.ok(studentDto);
  }

  @PutMapping("{id}")
  public ResponseEntity<StudentDto> patchStudent(@PathVariable Long id, @Valid @RequestBody StudentDto thStudentDto) {
    StudentDto studentDto = studentService.patchStudent(id, thStudentDto);
    return ResponseEntity.ok(studentDto);
  }

}
