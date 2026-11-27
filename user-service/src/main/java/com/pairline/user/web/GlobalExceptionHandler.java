package com.pairline.user.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.pairline.user.service.EmailAlreadyExistsException;
import com.pairline.user.service.InvalidCredentialsException;

@RestControllerAdvice // applies this rule to every controller.
public class GlobalExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT) // 409 conflict
	public String handleDuplicateEmail(EmailAlreadyExistsException ex) {
		return ex.getMessage();
	}

	@ExceptionHandler(InvalidCredentialsException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public String handleInvalidCredentials(InvalidCredentialsException ex) {
		return ex.getMessage();
	}
}
