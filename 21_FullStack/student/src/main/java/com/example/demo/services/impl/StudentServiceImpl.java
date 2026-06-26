package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.StudentDto;
import com.example.demo.entities.Student;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repo.StudentRepo;
import com.example.demo.services.interfaces.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepo studentRepo;
	private final ModelMapper modelMapper;

	@Override
	public StudentDto createStudent(StudentDto dto) {
		log.info("StudentServiceImpl|| createStudent | StudentDto: {}", dto);
		Student student = modelMapper.map(dto, Student.class);

		log.info("student: {}", student);
		dto = modelMapper.map(studentRepo.save(student), StudentDto.class);

		return dto;
	}

	@Override
	public List<StudentDto> getStudentList() {
		log.info("StudentServiceImpl || getStudentList");

		List<Student> studentList = studentRepo.findAll();

		return studentList.stream().map(student -> modelMapper.map(student, StudentDto.class)).toList();
	}

	@Override
	public StudentDto getStudent(Long id) {
		log.info("StudentServiceImpl || getStudent | Student id: {}", id);

		Student student = studentRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No such student exists in database!"));
		
		return modelMapper.map(student, StudentDto.class);
	}

	@Override
	public StudentDto updateStudent(Long id, StudentDto dto) {
		log.info("StudentServiceImpl || updating student : {}", id);

		Optional<Student> student = studentRepo.findById(id);

		if (student.isEmpty()) {
			log.info("StudentServiceImpl || No record found with id: {}", id);
			return null;

		} else {

			Student st = student.get();

			st.setUsername(dto.getUsername());
			st.setEmail(dto.getEmail());
			st.setDob(dto.getDob());
			st.setName(dto.getName());

			Student savedStudent = studentRepo.save(st);

			log.info("StudentServiceImpl || returning saved record...");
			return modelMapper.map(savedStudent, StudentDto.class);

		}

	}

	@Override
	public boolean deleteStudentById(Long studentId) {
		log.info("StudentServiceImpl || delete student id: {}", studentId);
		studentRepo.deleteById(studentId);
		return studentRepo.existsById(studentId);

	}

}
