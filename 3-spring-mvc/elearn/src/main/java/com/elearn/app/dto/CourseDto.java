package com.elearn.app.dto;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {
	private String id;
	@Size(min = 2, max = 100, message = "title must be between 2 to 100 characters.")
	private String title;
	private String banner;
	private double price;
	@Min(value = 5, message="Discount should have at least 5 percentage")
	@Max(value = 60, message="Discount can be only upto 60 percentage")
	private double discount;
	@Size(min=2, max=200, message="Short Description should be between 2 to 200 characters.")
	private String shortDescr;
	@Size(max=1000, message="Long description can be only upto 1000 characters long.")
	private String longDescr;
	private boolean live;
	private Date createdAt;
}
