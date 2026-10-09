package com.elearn.apis.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elearn.apis.dtos.CourseDto;
import com.elearn.apis.services.interfaces.CourseService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/courses")
@Slf4j
@AllArgsConstructor
public class CourseController {

	private final CourseService courseService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CourseDto getCourse(@RequestBody CourseDto dto) {
		log.info("CourseController | POST: {} ", dto);
		return courseService.saveCourse(dto);
	}

	@GetMapping
	public Page<CourseDto> getAllCourses() {
		log.info("CourseController | GET all ");
		return courseService.getAllCourses();
	}

	@GetMapping("/{courseId}")
	public CourseDto getCourse(@PathVariable UUID courseId) {
		log.info("CourseController | GET | id: {} ", courseId);
		return courseService.getCourseById(courseId);
	}

	@PutMapping("/{courseId}")
	public CourseDto updateCourse(@PathVariable UUID courseId, CourseDto dto) {
		log.info("CouseController  | PUT | id: {}, dto: {}", courseId, dto);
		return courseService.updateCourse(courseId, dto);
	}

	@DeleteMapping("/{courseId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCourse(@PathVariable UUID courseId) {
		log.info("CouseController  | DELETE | id: {}", courseId);
		courseService.delete(courseId);

	}

}
