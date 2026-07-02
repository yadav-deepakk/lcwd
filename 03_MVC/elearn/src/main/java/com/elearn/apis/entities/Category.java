package com.elearn.apis.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

	@Id
	@UuidGenerator
	private UUID id;

	@Column(nullable = false, length = 200)
	private String title;
	
	@Column(length = 500)
	private String description;
	
	@ManyToMany
	@Builder.Default
	Set<Course> courseSet = new HashSet<>(); 

}
