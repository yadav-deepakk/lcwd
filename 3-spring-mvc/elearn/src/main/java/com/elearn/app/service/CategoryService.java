package com.elearn.app.service;

import com.elearn.app.dto.CategoryDto;
import com.elearn.app.dto.PageResponse;
import com.elearn.app.exception.ResourceNotFoundException;

public interface CategoryService {
	// C - Create
	CategoryDto saveCategory(CategoryDto categoryDto);
	void addCourseToCategory(String categoryId, String courseId) throws ResourceNotFoundException, Exception;

	// R - Read
	PageResponse<CategoryDto> getCategoryList(int page, int size, String sortBy, String dir);
	CategoryDto getCategoryById(String id) throws ResourceNotFoundException, Exception;

	// U - Update
	CategoryDto updateCategory(String categoryId, CategoryDto categoryDto) throws ResourceNotFoundException, Exception;

	// D - Delete
	void deleteCategoryById(String id) throws ResourceNotFoundException, Exception;

}
