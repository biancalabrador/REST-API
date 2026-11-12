package com.spring.spring_rest.service;

import java.util.List;

import com.spring.spring_rest.dto.StudentDto;

public interface StudentService {
  StudentDto createStudent(StudentDto thStudentDto);
  StudentDto getStudentById(Long theId);
  List<StudentDto> getAllStudents();
}
