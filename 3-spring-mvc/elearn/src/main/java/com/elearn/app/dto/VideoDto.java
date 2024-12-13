package com.elearn.app.dto;

import java.sql.Date;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoDto {
	private String id;
	@Size(min=2, max=100, message="Title can be between 2 to 100 characters only.")
	private String title;
	private String filePath;  
	private Date uploadedAt;
    private String contentType;
}
