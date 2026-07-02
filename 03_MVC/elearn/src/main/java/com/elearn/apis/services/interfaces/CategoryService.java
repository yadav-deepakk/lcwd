package com.elearn.apis.services.interfaces;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.elearn.apis.dtos.CategoryDto;

public interface CategoryService {

	CategoryDto save(CategoryDto dto);

	CategoryDto getCategory(UUID uuid);

	Page<CategoryDto> getAllCategories(Pageable pageRequest);

	Page<CategoryDto> searchCategories(String keyword, Pageable pageRequest);

	CategoryDto update(UUID uuid, CategoryDto dto);

	void deleteById(UUID uuid);

}
