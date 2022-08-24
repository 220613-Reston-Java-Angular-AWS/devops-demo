package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository ur;
	
	public UserService(UserRepository ur) {
		this.ur = ur;
	}
	
	public List<User> findAll() {
		return ur.findAll();
	}
	
	public User findUserById(int id) {
		return ur.findById(id).orElseThrow(UserNotFoundException::new);
	}
	
	public User addUser(User user) {
		
		// Setting a default role for all new users.
		user.setRole(Role.BASIC_USER);
		
		return ur.save(user);
	}
}
