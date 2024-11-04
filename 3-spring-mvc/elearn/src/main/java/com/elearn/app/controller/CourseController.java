package com.elearn.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elearn.app.entities.Course;
import com.elearn.app.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@PostMapping
	public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
		return ResponseEntity.ok(courseService.saveCourse(course));
	}

	@GetMapping
	public ResponseEntity<List<Course>> getAllCourses() {
		return ResponseEntity.ok(courseService.getAllCourses());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(@RequestParam("id") String courseId) throws Exception {
		return ResponseEntity.ok(courseService.getCourseById(courseId));
	}

	@PutMapping
	public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
		return ResponseEntity.ok(courseService.updateCourse(course));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteCourse(@RequestParam("id") String courseId) {
		return ResponseEntity.ok(courseService.deleteCourseById(courseId));
	}

}