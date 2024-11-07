package com.elearn.app.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.elearn.app.dto.CategoryDto;
import com.elearn.app.dto.PageResponse;
import com.elearn.app.entities.Category;
import com.elearn.app.exception.ResourceNotFoundException;
import com.elearn.app.repository.CategoryRepo;
import com.elearn.app.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final ModelMapper modelMapper;
	private final CategoryRepo categoryRepo;

	public CategoryServiceImpl(ModelMapper modelMapper, CategoryRepo categoryRepo) {
		this.modelMapper = modelMapper;
		this.categoryRepo = categoryRepo;
	}

	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto) {
		Category category = modelMapper.map(categoryDto, Category.class);
		Category savedCategory = categoryRepo.save(category);
		return modelMapper.map(savedCategory, CategoryDto.class);
	}

	@Override
	public PageResponse<CategoryDto> getCategoryList(int page, int size, String sortBy) {
		Page<Category> pageOfCategories = categoryRepo.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
		List<CategoryDto> categoryDtoList = pageOfCategories.getContent().stream()
				.map(c -> modelMapper.map(c, CategoryDto.class)).toList();
		PageResponse<CategoryDto> response = PageResponse.<CategoryDto>builder()
				.pageNumber(pageOfCategories.getNumber()).PageSize(pageOfCategories.getSize())
				.totalElements(pageOfCategories.getTotalElements()).totalPages(pageOfCategories.getTotalPages())
				.last(pageOfCategories.isLast()).content(categoryDtoList).build();
		return response;
	}

	@Override
	public CategoryDto getCategoryById(String id) throws ResourceNotFoundException, Exception {
		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No such category found!"));
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(String categoryId, CategoryDto categoryDto)
			throws ResourceNotFoundException, Exception {
		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("No such category found to update!"));
		category.setTitle(categoryDto.getTitle());
		category.setDescr(categoryDto.getDescr());
		Category updatedCategory = categoryRepo.save(category);
		return modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategoryById(String id) throws ResourceNotFoundException, Exception {
		Category category = categoryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No such category found to delete!"));
		categoryRepo.delete(category);
	}

}
