package com.demo.practice.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.practice.app.entity.Student;
import com.demo.practice.app.repo.StudentRepo;
import com.demo.practice.app.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepo studentRepo;

	public StudentServiceImpl(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> studentList = studentRepo.findAll();
		return studentList;
	}

	@Override
	public Student getStudentById(String id) throws Exception {
		Student student = studentRepo.findById(id)
				.orElseThrow(() -> new Exception("No such student found with id : " + id));
		return student;
	}

	@Override
	public Student updateStudent(String id, Student student) throws Exception {
		Student s = studentRepo.findById(id).orElseThrow(() -> new Exception("No such student found with id : " + id));

		// update details
		s.setName(student.getName());
		s.setEmail(student.getEmail());
		s.setGender(student.getGender());
		s.setPhoneNo(student.getPhoneNo());

		Student updatedStudent = studentRepo.save(s);

		return updatedStudent;
	}

	@Override
	public boolean deleteStudent(String id) throws Exception {
		studentRepo.deleteById(id);
		Optional<Student> student = studentRepo.findById(id);
		if (student.isPresent())
			return false;
		else
			return true;
	}

	@Override
	public boolean deleteStudent(Student student) throws Exception {
		return this.deleteStudent(student.getId());
	}

}
