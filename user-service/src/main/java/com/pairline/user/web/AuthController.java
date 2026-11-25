package com.pairline.user.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pairline.user.service.UserService;

import jakarta.validation.Valid;

@RestController // Answers web requests and returns JSON
@RequestMapping("/api/v1/auth")
public class AuthController {

	private final UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	// @Valid runs the rules from RegisterRequest before this method starts
	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)					//201 created
	public UserResponse register(@Valid @RequestBody RegisterRequest request) {
		return userService.register(request);
	}
}
