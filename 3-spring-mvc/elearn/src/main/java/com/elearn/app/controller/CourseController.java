package com.elearn.app.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
import com.elearn.app.dto.PageResponse;
import com.elearn.app.exception.ResourceNotFoundException;
import com.elearn.app.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@PostMapping
	public ResponseEntity<CourseDto> saveCourse(@RequestBody @Valid CourseDto courseDto) {
		return ResponseEntity.ok(courseService.saveCourse(courseDto));
	}

	@GetMapping
	public ResponseEntity<PageResponse<CourseDto>> getCourseList(
			@RequestParam(name = "page", defaultValue = AppConstants.COURSE_DEFAULT_PAGE_NO) int pageNumber,
			@RequestParam(name = "size", defaultValue = AppConstants.COURSE_DEFAULT_PAGE_SIZE) int pageSize,
			@RequestParam(name = "sort", defaultValue = AppConstants.COURSE_DEFAULT_SORT_BY) String sortBy,
			@RequestParam(name = "dir", defaultValue = AppConstants.COURSE_DEFAULT_SORT_DIR) String sortDirection) {
		return ResponseEntity.ok(courseService.getAllCourses(pageNumber, pageSize, sortBy, sortDirection));
	}

	@GetMapping("/search")
	public ResponseEntity<PageResponse<CourseDto>> searchCourses(@RequestParam("key") String keyword,
			@RequestParam(name = "page", defaultValue = AppConstants.COURSE_DEFAULT_PAGE_NO) int pageNumber,
			@RequestParam(name = "size", defaultValue = AppConstants.COURSE_DEFAULT_PAGE_SIZE) int pageSize,
			@RequestParam(name = "sort", defaultValue = AppConstants.COURSE_DEFAULT_SORT_BY) String sortBy,
			@RequestParam(name = "dir", defaultValue = AppConstants.COURSE_DEFAULT_SORT_DIR) String sortDirection)
			throws ResourceNotFoundException, Exception {
		Sort sort = sortDirection.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
		return ResponseEntity.ok(courseService.getSearchedCourses(keyword, pageRequest));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CourseDto> getCourseById(@PathVariable("id") String courseId)
			throws ResourceNotFoundException, Exception {
		return ResponseEntity.ok(courseService.getCourseById(courseId));
	}

	@GetMapping("/{courseId}/categories/{categoryId}/")
	public ResponseEntity<CustomMessage> addCategoryToCourse(@PathVariable String courseId,
			@PathVariable String categoryId) throws ResourceNotFoundException, Exception {
		courseService.addCategoryToCourse(courseId, categoryId);
		CustomMessage message = CustomMessage.builder().message("category has been added to course!")
				.details("").success(true).build();
		return ResponseEntity.ok(message);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CourseDto> updateCourse(@PathVariable String id, @RequestBody CourseDto courseDto)
			throws ResourceNotFoundException, Exception {
		return ResponseEntity.ok(courseService.updateCourse(id, courseDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CustomMessage> deleteCourse(@PathVariable("id") String courseId)
			throws ResourceNotFoundException, Exception {
		courseService.deleteCourseById(courseId);
		CustomMessage message = CustomMessage.builder().message("course deleted!")
				.details("Course with id: " + courseId + " has been deleted!").success(true).build();
		return ResponseEntity.ok(message);
	}

}