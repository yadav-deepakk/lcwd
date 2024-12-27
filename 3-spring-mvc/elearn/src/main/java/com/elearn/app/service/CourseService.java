package com.elearn.app.service;

import com.elearn.app.dto.CourseDto;
import com.elearn.app.dto.PageResponse;
import com.elearn.app.exception.ResourceNotFoundException;

import org.springframework.data.domain.Pageable;

public interface CourseService {

	// C - Create
	CourseDto saveCourse(CourseDto courseDto);

	// R - Read
	PageResponse<CourseDto> getAllCourses(int page, int size, String sortBy, String sortDir);
	PageResponse<CourseDto> getSearchedCourses(String keyword, Pageable pageable);
	CourseDto getCourseById(String id) throws ResourceNotFoundException, Exception;

	// U - Update
	CourseDto updateCourse(String id, CourseDto course) throws ResourceNotFoundException, Exception;
	void addCategoryToCourse(String courseId, String categoryId) throws ResourceNotFoundException, Exception; 

	// D - Delete
	void deleteCourseById(String id) throws ResourceNotFoundException, Exception;
}
