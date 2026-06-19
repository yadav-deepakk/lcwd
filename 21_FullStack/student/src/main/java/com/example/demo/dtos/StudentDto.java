package com.example.demo.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class StudentDto {

	private Long studentId;
	private String name;
	private String email;
	private String username;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dob; 

}
