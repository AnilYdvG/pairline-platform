package com.pairline.user.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.pairline.user.service.EmailAlreadyExistsException;

@RestControllerAdvice // applies this rule to every controller.
public class GlobalExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT) // 409 conflict
	public String handleDuplicateEmail(EmailAlreadyExistsException ex) {
		return ex.getMessage();
	}
}
