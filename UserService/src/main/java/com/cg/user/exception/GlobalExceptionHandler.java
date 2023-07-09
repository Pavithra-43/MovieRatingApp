package com.cg.user.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ExceptionDetails> userException(UserException ex, WebRequest req){
		
		ExceptionDetails details=new ExceptionDetails(new Date(), ex.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
		
	}

}
