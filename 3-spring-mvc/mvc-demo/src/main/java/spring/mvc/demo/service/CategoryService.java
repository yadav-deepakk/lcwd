package spring.mvc.demo.service;

import java.util.List;
import java.util.Optional;

import spring.mvc.demo.entities.Category;

public interface CategoryService {
	// C - Create
	Category save(Category category); 
	
	// R - Read
	Optional<Category> getById(Integer id); 
	List<Category> getAllCategories(); 
	
	// U - Update
	Category update(Category category); 
	
	// D - Delete
	boolean deleteById(Integer id);
	boolean delete(Category category); 
}
