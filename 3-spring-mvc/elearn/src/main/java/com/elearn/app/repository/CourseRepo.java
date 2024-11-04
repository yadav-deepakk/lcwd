package com.elearn.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elearn.app.entities.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, String> {

}
