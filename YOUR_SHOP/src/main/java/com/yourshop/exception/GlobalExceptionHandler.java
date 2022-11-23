package com.yourshop.exception;

import java.time.LocalDateTime;

import javax.persistence.RollbackException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
//	---------------------------------------------------------------------
	
//	Global exception handler-
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> ExceptionHandler(Exception ie,WebRequest req) {
			
		MyErrorDetails me = new MyErrorDetails();
		me.setTimestamp(LocalDateTime.now());
		me.setMessage(ie.getMessage());
		me.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(me,HttpStatus.BAD_REQUEST);
		
		
	}
	
//	Method argument not valid exception-
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> notValidateHandler(MethodArgumentNotValidException ma) {
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Validation Error");
		err.setDescription(ma.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
//	No handler found exception-
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException nhf, WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(nhf.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
		
	}
	
//	RollBack exception
	@ExceptionHandler(RollbackException.class)
	public ResponseEntity<MyErrorDetails> handleRollbackException(RollbackException exp, WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(),
				"Improper arguments passed in json: Validation failed", req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

}
