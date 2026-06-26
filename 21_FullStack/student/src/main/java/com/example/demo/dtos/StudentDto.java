package com.example.demo.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentDto {

	private Long studentId;
	private String name;
	private String email;
	private String username;
	private LocalDate dob; 

}
