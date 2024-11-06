package com.elearn.app.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	private String id;
	private String name;
	private String email;
	private String phone;
	private String about;
	private String picture;
	private Date dob;
	private Date createdAt;

	private boolean active;
	private boolean emailVerified;
	private boolean phoneVerified;
	
}
