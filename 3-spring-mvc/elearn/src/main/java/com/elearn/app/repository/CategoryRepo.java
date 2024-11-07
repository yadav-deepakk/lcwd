package com.elearn.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elearn.app.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, String> {
	List<Category> findByTitleContaining(String keyword);
	List<Category> findByDescrContaining(String keyword);
}
