package com.cg.rate.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	public ResponseEntity<ExceptionDetails> handleRateException(RatingException ex, WebRequest req){
		ExceptionDetails details=new ExceptionDetails(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<ExceptionDetails>(details,HttpStatus.NOT_FOUND);
	}

}
