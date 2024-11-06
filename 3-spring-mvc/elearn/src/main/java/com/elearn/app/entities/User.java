package com.elearn.app.entities;

import java.util.Date;

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
public class User {
	@Id
	@UuidGenerator
	private String id;
	private String name;
	@Column(unique = true)
	private String email;
	private String phone;
	private String about;
	private String picture;
	private Date dob;
	private Date createdAt;

	private boolean active;
	private boolean emailVerified;
	private boolean phoneVerified;
	private String emailOtp;
	private String phoneOtp;
	
}
