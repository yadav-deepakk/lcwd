package com.elearn.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elearn.app.entities.Category;
import com.elearn.app.exception.ResourceNotFoundException;
import com.elearn.app.repository.CategoryRepo;
import com.elearn.app.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepo categoryRepo;

	public CategoryServiceImpl(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public Category getCategoryById(String id) throws Exception {
		return categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Such Category"));
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public boolean deleteCategoryById(String id) {
		categoryRepo.deleteById(id);
		return categoryRepo.findById(id).isEmpty();
	}

	@Override
	public boolean deleteCategory(Category category) {
		categoryRepo.delete(category);
		return categoryRepo.findById(category.getId()).isEmpty();
	}

}
