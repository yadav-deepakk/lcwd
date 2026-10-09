package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;

public interface CategoryRepo extends JpaRepository<Category, String> {
	
	// Crud operations present by default
	// save, findAll, findById, deleteById, delete, exitstById, count


}
