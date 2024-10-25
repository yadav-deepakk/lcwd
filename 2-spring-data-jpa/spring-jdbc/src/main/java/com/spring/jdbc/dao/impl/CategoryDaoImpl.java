package com.spring.jdbc.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.jdbc.dao.CategoryDao;
import com.spring.jdbc.model.Category;

import jakarta.annotation.PostConstruct;

@Component
public class CategoryDaoImpl implements CategoryDao {
	
	private final JdbcTemplate jdbcTemplate; 
	
	public CategoryDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate; 
	}
	
	@PostConstruct
	public void createCategoryTable() {
		String sql = "CREATE TABLE IF NOT EXISTS category(id INT PRIMARY KEY, name VARCHAR(100) NOT NULL);"; 
		jdbcTemplate.execute(sql); 
	}

	@Override
	public Category save(Category category) {
		return null;
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
