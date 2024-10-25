package com.spring.jdbc.dao;

import com.spring.jdbc.model.Category;
import java.util.List;

public interface CategoryDao {
	// C - Create
	Category save(Category category);

	// R - Read 
	List<Category> getAll();
	Category getById();

	// U - Update
	int update(Category category);

	// D - Delete
	int delete(Category category);
	int delete(int id);
}
