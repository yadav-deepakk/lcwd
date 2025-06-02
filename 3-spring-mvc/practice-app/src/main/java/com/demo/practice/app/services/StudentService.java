package com.demo.practice.app.services;

import java.util.List;

import com.demo.practice.app.entity.Student;

public interface StudentService {
	Student saveStudent(Student student); 
	List<Student> getAllStudent(); 
	Student getStudentById(String id) throws Exception; 
	Student updateStudent(String id, Student student) throws Exception; 
	boolean deleteStudent(String id) throws Exception; 
	boolean deleteStudent(Student student) throws Exception; 
}
