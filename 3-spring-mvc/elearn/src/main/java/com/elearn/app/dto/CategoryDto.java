package com.elearn.app.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
	private String id;

	@NotEmpty(message = "Title can not be empty")
	@Size(min = 2, max = 100, message = "Title must be between 2 to 100 characters.")
	private String title;

	@NotEmpty(message = "Description can not be empty.")
	@Size(min = 2, max = 1000, message = "Description must be between 2 to 100 characters.")
	private String descr;
	private Date createdAt;

}
