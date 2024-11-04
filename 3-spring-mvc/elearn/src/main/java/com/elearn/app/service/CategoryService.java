package com.elearn.app.service;

import java.util.List;

import com.elearn.app.entities.Category;

public interface CategoryService {
	// C - Create
	Category saveCategory(Category category); 
	
	// R - Read
	List<Category> getAllCategories(); 
	Category getCategoryById(String id) throws Exception; 
	
	// U - Update
	Category updateCategory(Category category); 
	
	// D - Delete
	boolean deleteCategoryById(String id); 
	boolean deleteCategory(Category category); 

}
