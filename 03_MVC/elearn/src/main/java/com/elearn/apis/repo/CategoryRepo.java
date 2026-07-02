package com.elearn.apis.repo;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.elearn.apis.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, UUID>{
	
	// all default crud methods 
	
	// custom finder method
	Page<Category> findByTitleContainingIgnoreCase(String keyword, Pageable page); 

}
