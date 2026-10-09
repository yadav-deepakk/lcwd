package com.elearn.apis.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearn.apis.entities.Course;

public interface CourseRepo extends JpaRepository<Course, UUID>{
	
	// CRUD

	// custom finder methods
	
	// JPQL and Native queries 
}
