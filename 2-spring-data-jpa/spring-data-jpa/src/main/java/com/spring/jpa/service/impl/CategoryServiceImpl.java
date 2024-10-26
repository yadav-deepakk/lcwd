package com.spring.jpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.jpa.entity.Category;
import com.spring.jpa.repository.CategoryRepository;
import com.spring.jpa.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepo;

	public CategoryServiceImpl(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	@Override
	public Category save(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Optional<Category> getById(Long id) {
		return categoryRepo.findById(id);
	}

	@Override
	public List<Category> getAll() {
		return categoryRepo.findAll();
	}

	@Override
	public Category update(Category category) {
		return this.save(category);
	}

	@Override
	public boolean deleteById(Long id) {
		categoryRepo.deleteById(id);
		return this.getById(id).isEmpty();
	}

	@Override
	public boolean delete(Category category) {
		categoryRepo.delete(category); 
		return this.getById(category.getId()).isEmpty();
	}

}
