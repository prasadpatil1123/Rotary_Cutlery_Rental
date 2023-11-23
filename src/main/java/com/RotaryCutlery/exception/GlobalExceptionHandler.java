package com.RotaryCutlery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
	

	//this exception was raised in userServiceImpl
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> resourceNotFoundHandler(ResourceNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource Not Found: "+ex.getMessage());
	}
	
	
	//this is global exception => wherever exception occurred here it will handle............
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handlerException(Exception ex){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occured: "+ex.getMessage());
	}
	
	
}
