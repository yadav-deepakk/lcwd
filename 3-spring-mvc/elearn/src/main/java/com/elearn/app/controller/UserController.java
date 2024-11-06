package com.elearn.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elearn.app.dto.UserDto;
import com.elearn.app.entities.User;
import com.elearn.app.exception.ResourceNotFoundException;
import com.elearn.app.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private final ModelMapper modelMapper;
	private final UserService userService;

	public UserController(ModelMapper modelMapper, UserService userService) {
		this.modelMapper = modelMapper;
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<UserDto> getUserByEmail(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		UserDto userDto = modelMapper.map(savedUser, UserDto.class);
		return ResponseEntity.ok(userDto);
	}

	@GetMapping()
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<User> userList = userService.getAllUsers();
		List<UserDto> userDtoList = userList.stream().map((u -> modelMapper.map(u, UserDto.class)))
				.collect(Collectors.toList());
		return ResponseEntity.ok(userDtoList);
	}

	@GetMapping("/email/{emailId}")
	public ResponseEntity<UserDto> getUserByEmail(@RequestParam("emailId") String email)
			throws ResourceNotFoundException, Exception {
		User user = userService.getUserByEmail(email);
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return ResponseEntity.ok(userDto);
	}

	@GetMapping("/userId/{userId}")
	public ResponseEntity<UserDto> getUserById(@RequestParam String userId)
			throws ResourceNotFoundException, Exception {
		User user = userService.getUserById(userId);
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return ResponseEntity.ok(userDto);
	}
	
	@PutMapping
	public ResponseEntity<UserDto> getUserById(@RequestBody User user){
		User updatedUser = userService.updateUser(user);
		UserDto userDto = modelMapper.map(updatedUser, UserDto.class);
		return ResponseEntity.ok(userDto);
	}

	@DeleteMapping
	public ResponseEntity<Boolean> deleteUserById(@RequestParam("id") String userId){
		boolean success = userService.deleteUserById(userId); 
		return ResponseEntity.ok(success); 
	}

}
