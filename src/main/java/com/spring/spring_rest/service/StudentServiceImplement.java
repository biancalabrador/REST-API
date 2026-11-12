package com.spring.spring_rest.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student;
import com.spring.spring_rest.exception.StudentNotFoundException;
import com.spring.spring_rest.mapper.StudentMapper;
import com.spring.spring_rest.repository.StudentRepository;

@Service 
public class StudentServiceImplement implements StudentService{
  
  private StudentRepository studentRepo;

  public StudentServiceImplement(StudentRepository studentRepo) {
    this.studentRepo = studentRepo;
  }

  @Override 
  public StudentDto createStudent(StudentDto theStudentDto) {
    Student theStudent = StudentMapper.mapToStudent(theStudentDto);
    Student saved = studentRepo.save(theStudent);
    return StudentMapper.mapToStudentDto(saved);
  }

  @Override 
  public StudentDto getStudentById(Long theId) {
    Student student = studentRepo.findById(theId)
      .orElseThrow(() -> new StudentNotFoundException("Student id" + theId + " not found!")
    );
    return StudentMapper.mapToStudentDto(student);
  }

  @Override 
  public List<StudentDto> getAllStudents() {
    List<Student> students = studentRepo.findAll();
    return students.stream().map(
      (student) -> StudentMapper.mapToStudentDto(student))
      .collect(Collectors.toList());
  }

}
