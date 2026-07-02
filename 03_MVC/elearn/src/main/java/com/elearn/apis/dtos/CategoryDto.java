package com.elearn.apis.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class CategoryDto {
	
	@Min(3)
	@Max(200)
	private String title;
	
	@Max(500)
	private String description;

}
