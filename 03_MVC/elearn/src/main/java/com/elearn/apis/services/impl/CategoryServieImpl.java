package com.elearn.apis.services.impl;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elearn.apis.dtos.CategoryDto;
import com.elearn.apis.dtos.CourseDto;
import com.elearn.apis.entities.Category;
import com.elearn.apis.entities.Course;
import com.elearn.apis.exceptions.ResourceNotFoundException;
import com.elearn.apis.repo.CategoryRepo;
import com.elearn.apis.repo.CourseRepo;
import com.elearn.apis.services.interfaces.CategoryService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryServieImpl implements CategoryService {

	private final ModelMapper modelMapper;
	private final CategoryRepo categoryRepo;
	private final CourseRepo courseRepo;

	@Override
	public CategoryDto save(CategoryDto dto) {
		log.info("CategoryServieImpl | save | dto: {}", dto);
		Category mappedCategory = modelMapper.map(dto, Category.class);
		return modelMapper.map(categoryRepo.save(mappedCategory), CategoryDto.class);
	}

	@Override
	public CategoryDto getCategory(UUID uuid) {
		log.info("CategoryServieImpl | get | uuid: {}", uuid);

		Category category = categoryRepo.findById(uuid)
				.orElseThrow(() -> new ResourceNotFoundException("No category found with id: " + uuid));
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public Page<CategoryDto> getAllCategories(Pageable pageRequest) {
		log.info("CategoryServieImpl | get all | page: {}, size: {}", pageRequest.getPageNumber(),
				pageRequest.getPageSize());
		Page<Category> pageCategory = categoryRepo.findAll(pageRequest);
		return pageCategory.map(category -> modelMapper.map(category, CategoryDto.class));
	}

	@Override
	public Page<CategoryDto> searchCategories(String keyword, Pageable pageRequest) {
		log.info("CategoryServieImpl | search Keyword: {} | page: {}, size: {}", keyword, pageRequest.getPageNumber(),
				pageRequest.getPageSize());

		Page<Category> pageCategory = categoryRepo.findByTitleContainingIgnoreCase(keyword, pageRequest);
		return pageCategory.map(category -> modelMapper.map(category, CategoryDto.class));
	}

	@Override
	public CategoryDto update(UUID uuid, CategoryDto dto) {
		log.info("CategoryServieImpl | update | uuid: {}, dto {}", uuid, dto);

		// take out the entity
		Category category = categoryRepo.findById(uuid)
				.orElseThrow(() -> new ResourceNotFoundException("No category found with id: " + uuid));

		// make modification to it with dto values
		category.setTitle(dto.getTitle());
		category.setDescription(dto.getDescription());

		// save it again and then return it
		Category updatedCategory = categoryRepo.save(category);
		return modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteById(UUID uuid) {
		log.info("CategoryServieImpl | delete | uuid: {}", uuid);
		categoryRepo.deleteById(uuid);
	}

	@Override
	public void saveCourse(UUID categoryId, UUID courseId) {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("No category found with id: " + categoryId));
		
		Course course = courseRepo.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("No course found with id: " + courseId));
		
		category.addCourse(course);
		
		categoryRepo.save(category); 
		
	}

	@Override
	public Page<CourseDto> getCoursesOfCategory(UUID uuid, Pageable pageRequest) {
		return null;
	}

}
