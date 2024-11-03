package spring.mvc.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import spring.mvc.demo.entities.Category;
import spring.mvc.demo.exceptions.ResourceNotFoundException;

public interface CategoryService {
	// C - Create
	Category save(Category category); 
	
	// R - Read
	Category getById(Integer id) throws ResourceNotFoundException; 
	List<Category> getAllCategories(); 
	
	// U - Update
	Category update(Category category); 
	
	// D - Delete
	boolean deleteById(Integer id);
	boolean delete(Category category);

	boolean uploadImage(MultipartFile file); 
}
