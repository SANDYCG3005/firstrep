package com.example.demo.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //makes this class as global exception handler
public class MainExceptionHandler{
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exe)
	{
		//create ErrorResponse obj
		ErrorResponse err= new ErrorResponse();
		err.setTimestamp(LocalDateTime.now());
		err.setHttp( HttpStatus.NOT_FOUND);
		err.setMessage( exe.getMessage());
		return new ResponseEntity<ErrorResponse>(err,HttpStatus.NOT_FOUND);
	}
	

}
