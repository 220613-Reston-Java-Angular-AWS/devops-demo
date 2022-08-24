package com.revature.dtos;

import com.revature.models.Role;
import com.revature.models.User;

import lombok.Data;

@Data
public class UserDTO {

	private int id;
	private String username;
	private Role role;
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.role = user.getRole();
	}
}
