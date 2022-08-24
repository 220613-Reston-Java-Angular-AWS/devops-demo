package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.UserDTO;
import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	private UserService us;
	
	public UserController(UserService us){
		this.us = us;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getAll(){
		List<User> users = us.findAll();
		
		if(users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		// converting User objects to DTOs
		List<UserDTO> userDTOs = new ArrayList<>();
		users.stream().forEach(user -> userDTOs.add(new UserDTO(user)));
		
		return ResponseEntity.ok(userDTOs);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getById(int id){
		User user = us.findUserById(id);
		
		UserDTO userDto = new UserDTO(user);
		
		return ResponseEntity.ok(userDto);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> addUser(User user){
		User newUser = us.addUser(user);
		
		UserDTO userDto = new UserDTO(newUser);
		
		return ResponseEntity.ok(userDto);
	}
}
