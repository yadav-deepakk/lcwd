package com.demo.practice.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.practice.app.entity.Student;
import com.demo.practice.app.services.impl.StudentServiceImpl;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

	private StudentServiceImpl studentService;

	public StudentController(StudentServiceImpl studentService) {
		this.studentService = studentService;
	}

	@PostMapping
	public Student saveStudent(@RequestBody Student student) {
		Student s = studentService.saveStudent(student);
		return s;
	}

	@GetMapping
	public List<Student> getAll() {
		List<Student> studentList = studentService.getAllStudent();
		return studentList;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getById(@PathVariable(required = true) String id) throws Exception {
		Student student = studentService.getStudentById(id);
		return ResponseEntity.ok(student);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable(required = true) String id, @RequestBody Student student) throws Exception {
		Student s = studentService.updateStudent(id, student);
		return ResponseEntity.ok(s);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(required = true) String id) throws Exception {
		return ResponseEntity.ok(studentService.deleteStudent(id)); 
	}

}
