package com.elearn.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elearn.app.dto.CategoryDto;
import com.elearn.app.entities.Category;
import com.elearn.app.service.CategoryService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

	private final ModelMapper modelMapper; 
	private final CategoryService categoryService;

	public CategoryController(ModelMapper modelMapper, CategoryService categoryService) {
		this.modelMapper = modelMapper; 
		this.categoryService = categoryService;
	}

	@PostMapping
	public ResponseEntity<CategoryDto> saveCategory(@RequestBody Category category) {
		Category savedCategory = categoryService.saveCategory(category); 
		CategoryDto categoryDto = modelMapper.map(savedCategory, CategoryDto.class); 
		return ResponseEntity.ok(categoryDto);
	}

	@GetMapping
	public ResponseEntity<List<CategoryDto>> getAllCategories() {
		List<Category> categoryList = categoryService.getAllCategories();
		List<CategoryDto> categoryDtoList = categoryList.stream().map(c -> modelMapper.map(c, CategoryDto.class)).collect(Collectors.toList()); 
		return ResponseEntity.ok(categoryDtoList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@RequestParam("id") String categoryId) throws Exception {
		Category category = categoryService.getCategoryById(categoryId); 
		CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class); 
		return ResponseEntity.ok(categoryDto);
	}

	@PutMapping
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody Category category) {
		Category updatedCategory = categoryService.updateCategory(category); 
		CategoryDto categoryDto = modelMapper.map(updatedCategory, CategoryDto.class); 
		return ResponseEntity.ok(categoryDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteCategory(@RequestParam("id") String categoryId) {
		return ResponseEntity.ok(categoryService.deleteCategoryById(categoryId));
	}
}