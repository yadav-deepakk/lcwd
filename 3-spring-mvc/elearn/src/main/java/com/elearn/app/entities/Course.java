package com.elearn.app.entities;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
public class Course {

	@Id
	@UuidGenerator
	private String id;
	private String title;
	private String banner;
	private double price;
	private double discount;
	private String shortDescr;
	private String longDescr;
	private String live;
	private Date createdAt;

	@Builder.Default
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private Set<Video> videoSet = new LinkedHashSet<>();

	@Builder.Default
	@ManyToMany(mappedBy = "courseSet")
	private Set<Category> categorySet = new LinkedHashSet<>();

}
