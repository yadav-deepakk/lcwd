package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.dtos.StudentDto;

public interface StudentService {

	public StudentDto createStudent(StudentDto studentDto);
	public List<StudentDto> getStudentList();
	public StudentDto getStudent(Long id);
	public StudentDto updateStudent(Long id, StudentDto studentDto);
	public boolean deleteStudentById(Long studentId);

}
