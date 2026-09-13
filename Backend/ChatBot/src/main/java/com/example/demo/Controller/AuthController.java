package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ApiResponseDTO;
import com.example.demo.Entity.User;
import com.example.demo.Service.AuthService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

	@Autowired
	AuthService authService;

	@PostMapping("login")
	public ResponseEntity<ApiResponseDTO<User>> login(@RequestBody User user) {
		try {
			User loggedInUser = authService.handleLogin(user);
			if (loggedInUser != null) {
				return ResponseEntity.ok(new ApiResponseDTO<>("Login successful", true, loggedInUser));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponseDTO<>("Login failed", false, null));
	}
	
	

	@PostMapping("/register")
	public ResponseEntity<ApiResponseDTO<User>> register(@RequestBody User user) {
		try {
			User registeredUser = authService.handleRegister(user);
			if (registeredUser != null) {
				return ResponseEntity.ok(new ApiResponseDTO<>("Registration successful", true, registeredUser));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseDTO<>("Registration failed", false, null));
	}

}
