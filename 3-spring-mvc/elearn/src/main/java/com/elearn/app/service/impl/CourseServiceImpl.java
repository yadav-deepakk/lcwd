package com.elearn.app.service.impl;

import com.elearn.app.dto.CourseDto;
import com.elearn.app.entities.Course;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
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
		Course savedCourse = courseRepo.save(course);
		return modelMapper.map(savedCourse, CourseDto.class);
	}

	@Override
	public List<CourseDto> getAllCourses(int page, int size, String sortBy) {
		List<Course> courseList = courseRepo.findAll(PageRequest.of(page, size, Sort.by(sortBy))).getContent();
		return courseList.stream().map(course -> modelMapper.map(course, CourseDto.class)).toList();
	}

	@Override
	public CourseDto getCourseById(String id) throws ResourceNotFoundException, Exception {
		Course course = courseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Such Course Found!"));
		return modelMapper.map(course, CourseDto.class);
	}

	@Override
	public CourseDto updateCourse(CourseDto courseDto) throws ResourceNotFoundException, Exception {
		Course course = courseRepo.findById(courseDto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No Such Course Found to update!"));

		course.setTitle(courseDto.getTitle());
		course.setBanner(courseDto.getBanner());
		course.setShortDescr(courseDto.getShortDescr());
		course.setLongDescr(courseDto.getLongDescr());
		course.setPrice(courseDto.getPrice());
		course.setDiscount(courseDto.getDiscount());
		course.setLive(courseDto.getLive());
		course.setCreatedAt(courseDto.getCreatedAt());

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
