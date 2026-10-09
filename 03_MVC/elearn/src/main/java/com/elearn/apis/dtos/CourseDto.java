package com.elearn.apis.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import lombok.Data;

@Data
public class CourseDto {

	private Long id;

	private String title;

	private String shortDescription;

	private String longDescription;

	private BigDecimal price;

	private String banner;

	private boolean live;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;
	
	private Set<CategoryDto> categories; 

}
