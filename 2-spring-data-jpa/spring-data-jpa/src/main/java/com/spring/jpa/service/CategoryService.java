package com.spring.jpa.service;

import java.util.List;
import java.util.Optional;

import com.spring.jpa.entity.Category;

public interface CategoryService {

	// C - Create
	Category save(Category category);

	// R - Read
	Optional<Category> getById(Long id);
	List<Category> getAll();

	// U - Update
	Category update(Category category);

	// D - Delete
	boolean deleteById(Long id);
	boolean delete(Category category);
}
