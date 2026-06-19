package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.StudentDto;
import com.example.demo.services.interfaces.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/students")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

  private final StudentService studentService;

  @GetMapping("/hello")
  public String hello(@RequestParam("student") String name) {
    log.info("logging the simple hello world!");
    return "<h3 align='center'> Hello, " + name.toLowerCase() + "!</h3>";
  }

  @PostMapping
  public StudentDto postStudent(@RequestBody StudentDto s) {
    log.info("StudentController || postStudent| POST: studentDto: {}", s);
    StudentDto studentDto = studentService.createStudent(s);
    return studentDto;
  }

  @GetMapping("/{id}")
  public StudentDto getStudentById(@PathVariable Long id) {
    log.info("StudentController || getStudent| GET: student id: {}", id);
    return studentService.getStudent(id);
  }

  @GetMapping
  public List<StudentDto> getStudents() {
    log.info("StudentController || getStudents| GET: students");
    return studentService.getStudentList();
  }

  @PutMapping("/{id}")
  public StudentDto putStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
    log.info("StudentController || putStudent| PUT: studentDto: {}", studentDto);
    StudentDto updatedStudent = studentService.updateStudent(id, studentDto);
    return updatedStudent;
  }

  @DeleteMapping("/{id}")
  public boolean deleteStudent(@PathVariable Long id) {
    log.info("StudentController || deleteStudent| DELETE: id: {}", id);
    return studentService.deleteStudentById(id);
  }

}
