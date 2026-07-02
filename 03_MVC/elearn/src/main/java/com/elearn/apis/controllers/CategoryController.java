package com.elearn.apis.controllers;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elearn.apis.dtos.CategoryDto;
import com.elearn.apis.services.interfaces.CategoryService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/categories")
@AllArgsConstructor
public class CategoryController {

	private final CategoryService categoryService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CategoryDto postCategory(@RequestBody CategoryDto dto) {
		log.info("CategoryController | postCategory | POST: dto: {}", dto);
		return categoryService.save(dto);
	}

	@GetMapping
	public Page<CategoryDto> getAllCategories(@PageableDefault(page = 0, size = 10) Pageable page) {
		log.info("CategoryController | GET| All");
		return categoryService.getAllCategories(page);
	}

	@GetMapping("/{categoryId}")
	public CategoryDto getCategoryById1(@PathVariable UUID categoryId) {
		log.info("CategoryController | GET| id:{}", categoryId);
		return categoryService.getCategory(categoryId);
	}

	@GetMapping("/search")
	public Page<CategoryDto> getCategoryById(@RequestParam String keyword,
			@PageableDefault(page = 0, size = 10) Pageable page) {
		log.info("CategoryController | Search | key:{}", keyword);
		return categoryService.searchCategories(keyword, page);
	}

	@PutMapping("/{id}")
	public CategoryDto putCategory(@PathVariable UUID id, @RequestBody CategoryDto dto) {
		log.info("CategoryController | PUT | id: {} and dto: {}", id, dto);
		return categoryService.update(id, dto);
	}

	@DeleteMapping("/{categoryId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletCategory(@PathVariable UUID categoryId) {
		log.info("CategoryController | deletCategory ", categoryId);
		categoryService.deleteById(categoryId);
	}

	@PostMapping("/{categoryId}/courses/{courseId}")
	public void addCourseToCategory(@PathVariable UUID categoryId, @PathVariable UUID courseId) {
		log.info("CategoryController | POST | categoryId: {} and courseId: {}", categoryId, courseId);
	}

	@GetMapping("/{categoryId}/courses")
	public void getAllCoursesOfCategory(@PathVariable UUID categoryId) {
		log.info("CategoryController | GET | categoryId: {}", categoryId);

	}

}
