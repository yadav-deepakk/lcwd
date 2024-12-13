package com.elearn.app.entities;

import java.util.Date;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Video {

	@Id
	@UuidGenerator
	private String id;
	private String title;
	private String filePath;  
	private Date uploadedAt;
    private String contentType;

	@ManyToOne
	private Course course;

}
