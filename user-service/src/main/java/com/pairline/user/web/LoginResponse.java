package com.pairline.user.web;

public record LoginResponse (
		
		String accessToken,
		String tokenType,
		long expiresInSeconds		
		){
}
