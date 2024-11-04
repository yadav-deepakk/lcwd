package com.elearn.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elearn.app.entities.Category;
import com.elearn.app.service.CategoryService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping
	public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.saveCategory(category));
	}

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories() {
		return ResponseEntity.ok(categoryService.getAllCategories());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@RequestParam("id") String categoryId) throws Exception {
		return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
	}

	@PutMapping
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.updateCategory(category));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteCategory(@RequestParam("id") String categoryId) {
		return ResponseEntity.ok(categoryService.deleteCategoryById(categoryId));
	}
}