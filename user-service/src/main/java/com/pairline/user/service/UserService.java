package com.pairline.user.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.pairline.user.model.User;
import com.pairline.user.repository.UserRepository;
import com.pairline.user.web.LoginRequest;
import com.pairline.user.web.LoginResponse;
import com.pairline.user.web.RegisterRequest;
import com.pairline.user.web.UserResponse;

// @Service tells spring to create this class once and share it
@Service
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	// Spring passes in the repository automatically (constructor injection
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserResponse register(RegisterRequest request) {
		// Business rule: each email can register only once
		if (userRepository.existsByEmail(request.email())) {
			throw new EmailAlreadyExistsException(request.email());
		}
		User user = new User();
		user.setEmail(request.email());
		user.setDisplayName(request.displayName());
		// Never store raw password. Hash it first
		user.setPasswordHash(passwordEncoder.encode(request.password()));

		User saved = userRepository.save(user);
		return UserResponse.from(user);
	}

	public LoginResponse login(LoginRequest request) {
		Optional<User> found = userRepository.findByEmail(request.email());

		if (found.isEmpty() || !passwordEncoder.matches(request.password(), found.get().getPasswordHash())) {
			throw new InvalidCredentialsException();
		}

		return new LoginResponse("", "Bearer", 0L);
	}
}
