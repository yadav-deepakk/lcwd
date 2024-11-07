package com.elearn.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elearn.app.constants.AppConstants;
import com.elearn.app.dto.CategoryDto;
import com.elearn.app.dto.CustomMessage;
import com.elearn.app.dto.PageResponse;
import com.elearn.app.exception.ResourceNotFoundException;
import com.elearn.app.service.CategoryService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping
	public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto) {
		CategoryDto savedCategoryDto = categoryService.saveCategory(categoryDto);
		return ResponseEntity.ok(savedCategoryDto);
	}

	@GetMapping
	public ResponseEntity<PageResponse<CategoryDto>> getCategoryList(
			@RequestParam(name = "page", defaultValue = AppConstants.CATEGORY_DEFAULT_PAGE_NO) int pageNumber,
			@RequestParam(name = "size", defaultValue = AppConstants.CATEGORY_DEFAULT_PAGE_SIZE) int pageSize,
			@RequestParam(name = "sort", defaultValue = AppConstants.CATEGORY_DEFAULT_SORT_BY) String sortBy) {
		PageResponse<CategoryDto> categoryDtoList = categoryService.getCategoryList(pageNumber, pageSize, sortBy);
		return ResponseEntity.ok(categoryDtoList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") String categoryId) throws Exception {
		CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
		return ResponseEntity.ok(categoryDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") String categoryId,
			@RequestBody CategoryDto categoryDto) throws ResourceNotFoundException, Exception {
		CategoryDto updatedCategory = categoryService.updateCategory(categoryId, categoryDto);
		return ResponseEntity.ok(updatedCategory);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CustomMessage> deleteCategory(@PathVariable("id") String categoryId)
			throws ResourceNotFoundException, Exception {
		categoryService.deleteCategoryById(categoryId);
		CustomMessage message = CustomMessage.builder().message("Category deleted!")
				.details("Category with id " + categoryId + " has been deleted successfully!").success(true).build();
		return ResponseEntity.ok(message);
	}

}