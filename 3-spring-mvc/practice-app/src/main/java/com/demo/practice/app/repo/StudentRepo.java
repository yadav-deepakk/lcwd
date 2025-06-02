package com.demo.practice.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.practice.app.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, String> {

}
