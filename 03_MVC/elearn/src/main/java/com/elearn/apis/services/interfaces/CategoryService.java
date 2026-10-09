package com.elearn.apis.services.interfaces;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.elearn.apis.dtos.CategoryDto;
import com.elearn.apis.dtos.CourseDto;

public interface CategoryService {

	CategoryDto save(CategoryDto dto);
	
	void saveCourse(UUID categoryId, UUID courseId);

	CategoryDto getCategory(UUID uuid);

	Page<CategoryDto> getAllCategories(Pageable pageRequest);

	Page<CategoryDto> searchCategories(String keyword, Pageable pageRequest);
	
	Page<CourseDto> getCoursesOfCategory(UUID uuid, Pageable pageRequest);

	CategoryDto update(UUID uuid, CategoryDto dto);

	void deleteById(UUID uuid);


}
