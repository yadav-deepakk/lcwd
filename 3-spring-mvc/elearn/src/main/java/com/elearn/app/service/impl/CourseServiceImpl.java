package com.elearn.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elearn.app.entities.Course;
import com.elearn.app.exception.ResourceNotFoundException;
import com.elearn.app.repository.CourseRepo;
import com.elearn.app.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private final CourseRepo courseRepo;

	public CourseServiceImpl(CourseRepo courseRepo) {
		this.courseRepo = courseRepo;
	}

	@Override
	public Course saveCourse(Course course) {
		return courseRepo.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepo.findAll();
	}

	@Override
	public Course getCourseById(String id) throws Exception {
		return courseRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Such Course Found!"));
	}

	@Override
	public Course updateCourse(Course course) {
		return courseRepo.save(course);
	}

	@Override
	public boolean deleteCourseById(String id) {
		courseRepo.deleteById(id);
		return courseRepo.findById(id).isEmpty();
	}

	@Override
	public boolean deleteCourse(Course course) {
		courseRepo.delete(course);
		return courseRepo.findById(course.getId()).isEmpty();
	}
}
