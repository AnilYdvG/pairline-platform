package com.pairline.user.web;

import java.time.Instant;

import com.pairline.user.model.User;



// Response --> leaves the server ,so never includes passwordHash
public record UserResponse(
		Long id,
		String email,
		String displayName,
		Instant createdAt
) {
	// A factory method: static-> builds this record from a User
	// Keeping the copying in one place -> response shape is decided here only
	public static UserResponse from(User user) {
		return new UserResponse(
				user.getId(), 
				user.getEmail(), 
				user.getDisplayName(), 
				user.getCreatedAt()
			);
	}
}
