package com.elearn.app.dto;

import java.sql.Date;

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
	private String title;
	private String banner;
	private double price;
	private double discount;
	private String shortDescr;
	private String longDescr;
	private String live;
	private Date createdAt;
}
