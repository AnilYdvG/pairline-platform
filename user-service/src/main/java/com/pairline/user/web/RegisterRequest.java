package com.pairline.user.web;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// record- short class holds only data. It's fields can't be changes after creation
public record RegisterRequest(

		@NotBlank 											// rejects empty or space only texts
		@Email 												// check the text look like an email address
		@Size(max = 255)									 // matches the MYSQL email column
		String email,

		@NotBlank 
		@Size(min = 8, max = 72) 					// basic min=8, BCrypt limit=72--> hashing mtd use only first 72 bytes of password
		String password,

		@NotBlank 											// matches the same from mysql
		@Size(max = 50) 
		String displayName

) {
}
