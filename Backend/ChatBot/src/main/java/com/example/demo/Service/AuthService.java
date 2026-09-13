package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;

@Service
public class AuthService {
	@Autowired
	UserService userService;
	
	public User handleLogin(User user) {
		try {
			User existingUser = userService.getUserByEmail(user.getEmail());
			if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
				return existingUser;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public User handleRegister(User user) {
		try {
			User existingUser = userService.getUserById(user.getId());
			if (existingUser == null) {
				return userService.createUser(user);
			}
		} catch (Exception e) {	
			// TODO: handle exception
		return null;
	}
		return null;

}}
