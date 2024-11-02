package spring.mvc.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import spring.mvc.demo.entities.Category;
import spring.mvc.demo.repo.CategoryRepo;
import spring.mvc.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepo categoryRepo;

	public CategoryServiceImpl(CategoryRepo categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	@Override
	public Category save(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Optional<Category> getById(Integer id) {
		return categoryRepo.findById(id);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepo.findAll();
	}

	@Override
	public Category update(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public boolean deleteById(Integer id) {
		categoryRepo.deleteById(id);
		return this.getById(id).isEmpty();
	}

	@Override
	public boolean delete(Category category) {
		categoryRepo.delete(category);
		return this.getById(category.getId()).isEmpty();
	}

}
