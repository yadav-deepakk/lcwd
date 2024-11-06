package com.elearn.app.service;

import java.util.List;

import com.elearn.app.entities.User;
import com.elearn.app.exception.ResourceNotFoundException;

public interface UserService {

	// C - Create 
	User saveUser(User user); 
	
	// R - Read 
	User getUserByEmail(String email) throws ResourceNotFoundException, Exception; 
	User getUserById(String id) throws ResourceNotFoundException, Exception; 
	List<User> getAllUsers(); 
	
	// U - Update 
	User updateUser(User user); 
	
	// D - Delete 
	boolean deleteUserById(String id); 
	boolean delete(User user); 
}
