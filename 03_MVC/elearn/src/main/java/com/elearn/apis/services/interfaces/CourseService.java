package com.elearn.apis.services.interfaces;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.elearn.apis.dtos.CourseDto;

public interface CourseService {

	CourseDto saveCourse(CourseDto dto);

	Page<CourseDto> getAllCourses();

	Page<CourseDto> searchCourses();

	CourseDto getCourseById(UUID uuid);

	CourseDto updateCourse(UUID uuid, CourseDto dto);

	void delete(UUID uuid);

}
