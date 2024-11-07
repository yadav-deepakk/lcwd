package com.elearn.app.service;

import com.elearn.app.dto.CourseDto;
import com.elearn.app.exception.ResourceNotFoundException;

import java.util.List;

public interface CourseService {

	// C - Create
	CourseDto saveCourse(CourseDto courseDto);

	// R - Read
	List<CourseDto> getAllCourses(int page, int size, String sortBy);
	CourseDto getCourseById(String id) throws ResourceNotFoundException, Exception;

	// U - Update
	CourseDto updateCourse(CourseDto course) throws ResourceNotFoundException, Exception;

	// D - Delete
	void deleteCourseById(String id) throws ResourceNotFoundException, Exception;
}
