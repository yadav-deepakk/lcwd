package spring.mvc.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import spring.mvc.demo.entities.Category;
import spring.mvc.demo.exceptions.ResourceNotFoundException;
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
	public boolean uploadImage(MultipartFile file) {
		boolean isSuccess = false;
		// *** code to upload image ***
		System.out.println("Uploaded file : " + file.getOriginalFilename());
		isSuccess = true;
		return isSuccess;
	}

	@Override
	public Category getById(Integer id) throws ResourceNotFoundException {
		try {
			return categoryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Such Category!"));
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
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
		return categoryRepo.findById(id).isEmpty();
	}

	@Override
	public boolean delete(Category category) {
		categoryRepo.delete(category);
		return categoryRepo.findById(category.getId()).isEmpty();
	}

}
