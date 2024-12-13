package com.elearn.app.service.impl;

import com.elearn.app.dto.CourseDto;
import com.elearn.app.dto.PageResponse;
import com.elearn.app.entities.Course;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.elearn.app.exception.ResourceNotFoundException;
import com.elearn.app.repository.CourseRepo;
import com.elearn.app.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private final ModelMapper modelMapper;
	private final CourseRepo courseRepo;

	public CourseServiceImpl(ModelMapper modelMapper, CourseRepo courseRepo) {
		this.modelMapper = modelMapper;
		this.courseRepo = courseRepo;
	}

	@Override
	public CourseDto saveCourse(CourseDto courseDto) {
		Course course = modelMapper.map(courseDto, Course.class);
		course.setCreatedAt(new Date());
		Course savedCourse = courseRepo.save(course);
		return modelMapper.map(savedCourse, CourseDto.class);
	}

	@Override
	public PageResponse<CourseDto> getAllCourses(int page, int size, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
		Page<Course> coursePage = courseRepo.findAll(PageRequest.of(page, size, sort));
		List<Course> courseList = coursePage.getContent();
		PageResponse<CourseDto> pageResponse = PageResponse.<CourseDto>builder().pageSize(coursePage.getSize())
				.pageNumber(coursePage.getNumber()).totalElements(coursePage.getTotalElements())
				.totalPages(coursePage.getTotalPages())
				.last(coursePage.isLast())
				.content(courseList.stream().map(course -> modelMapper.map(course, CourseDto.class)).toList()).build();
		return pageResponse;
	}

	@Override
	public PageResponse<CourseDto> getSearchedCourses(String keyword, Pageable pageable) {
		Page<Course> searchedCoursePage = courseRepo.findByTitleContainingOrShortDescrContaining(keyword, keyword,
				pageable);
		List<Course> courseList = searchedCoursePage.getContent();
		PageResponse<CourseDto> pageResponse = PageResponse.<CourseDto>builder().pageSize(searchedCoursePage.getSize())
				.pageNumber(searchedCoursePage.getNumber()).totalElements(searchedCoursePage.getTotalElements())
				.totalPages(searchedCoursePage.getTotalPages())
				.last(searchedCoursePage.isLast())
				.content(courseList.stream().map(course -> modelMapper.map(course, CourseDto.class)).toList()).build();
		return pageResponse;

	}

	@Override
	public CourseDto getCourseById(String id) throws ResourceNotFoundException, Exception {
		Course course = courseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Such Course Found!"));
		return modelMapper.map(course, CourseDto.class);
	}

	@Override
	public CourseDto updateCourse(String id, CourseDto courseDto) throws ResourceNotFoundException, Exception {
		Course course = courseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Such Course Found to update!"));

		course.setTitle(courseDto.getTitle());
		course.setBanner(courseDto.getBanner());
		course.setShortDescr(courseDto.getShortDescr());
		course.setLongDescr(courseDto.getLongDescr());
		course.setPrice(courseDto.getPrice());
		course.setDiscount(courseDto.getDiscount());
		course.setLive(courseDto.isLive());

		Course updatedCourse = courseRepo.save(course);

		return modelMapper.map(updatedCourse, CourseDto.class);
	}

	@Override
	public void deleteCourseById(String id) throws ResourceNotFoundException, Exception {
		Course course = courseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Such Course Found to delete!"));
		courseRepo.delete(course);
	}

}
