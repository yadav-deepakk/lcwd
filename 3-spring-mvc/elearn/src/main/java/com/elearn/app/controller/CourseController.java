package com.elearn.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elearn.app.constants.AppConstants;
import com.elearn.app.dto.CourseDto;
import com.elearn.app.dto.CustomMessage;
import com.elearn.app.entities.Course;
import com.elearn.app.exception.ResourceNotFoundException;
import com.elearn.app.service.CourseService;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@PostMapping
	public ResponseEntity<CourseDto> saveCourse(@RequestBody CourseDto courseDto) {
		return ResponseEntity.ok(courseService.saveCourse(courseDto));
	}

	@GetMapping
	public ResponseEntity<List<CourseDto>> getCourseList(
			@RequestParam(name = "page", defaultValue = AppConstants.CATEGORY_DEFAULT_PAGE_NO) int pageNumber,
			@RequestParam(name = "size", defaultValue = AppConstants.CATEGORY_DEFAULT_PAGE_SIZE) int pageSize,
			@RequestParam(name = "sort", defaultValue = AppConstants.CATEGORY_DEFAULT_SORT_BY) String sortBy) {

		return ResponseEntity.ok(courseService.getAllCourses(pageNumber, pageSize, sortBy));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable("id") String courseId)
			throws ResourceNotFoundException, Exception {
		return ResponseEntity.ok(courseService.getCourseById(courseId));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CourseDto> updateCourse(@PathVariable String id, @RequestBody CourseDto courseDto)
			throws ResourceNotFoundException, Exception {
		return ResponseEntity.ok(courseService.updateCourse(courseDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CustomMessage> deleteCourse(@RequestParam("id") String courseId)
			throws ResourceNotFoundException, Exception {
		courseService.deleteCourseById(courseId);
		CustomMessage message = CustomMessage.builder().message("course deleted!")
				.details("Course with id: " + courseId + " has been deleted!").build();
		return ResponseEntity.ok(message);
	}

}