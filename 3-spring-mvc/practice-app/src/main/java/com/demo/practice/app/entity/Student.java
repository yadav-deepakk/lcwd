package com.demo.practice.app.entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Entity
public class Student {

	@Id
	@UuidGenerator
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String gender; 
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String phoneNo; 
	
}
