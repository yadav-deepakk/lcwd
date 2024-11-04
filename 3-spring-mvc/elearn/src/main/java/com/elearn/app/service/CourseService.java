package com.elearn.app.service;

import java.util.List;

import com.elearn.app.entities.Course;

public interface CourseService {

	// C - Create 
	Course saveCourse(Course course); 
	
	// R - Read
	List<Course> getAllCourses(); 
	Course getCourseById(String id) throws Exception; 
	
	// U - Update
	Course updateCourse(Course course); 
	
	// D - Delete
	boolean deleteCourseById(String id); 
	boolean deleteCourse(Course course); 
}
