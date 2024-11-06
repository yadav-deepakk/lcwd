package com.elearn.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elearn.app.entities.User;
import com.elearn.app.exception.ResourceNotFoundException;
import com.elearn.app.repository.UserRepo;
import com.elearn.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepo userRepo;

	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUserByEmail(String email) throws ResourceNotFoundException, Exception {
		return userRepo.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("No user found with " + email + " email id."));
	}

	@Override
	public User getUserById(String id) throws ResourceNotFoundException, Exception {
		return userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No user found with user id " + id));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public boolean deleteUserById(String id) {
		userRepo.deleteById(id);
		return userRepo.findById(id).isEmpty();
	}

	@Override
	public boolean delete(User user) {
		userRepo.delete(user);
		return userRepo.findById(user.getId()).isEmpty();
	}

}
