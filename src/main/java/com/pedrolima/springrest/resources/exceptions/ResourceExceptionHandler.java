package com.pedrolima.springrest.resources.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.pedrolima.springrest.services.exceptions.AuthorizationException;
import com.pedrolima.springrest.services.exceptions.DataIntegrityException;
import com.pedrolima.springrest.services.exceptions.FileException;
import com.pedrolima.springrest.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), LocalDateTime.now().toString());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> constraintIntegrityException(DataIntegrityException e,
			HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), LocalDateTime.now().toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation (MethodArgumentNotValidException e, HttpServletRequest request) {
		
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Validation Error", LocalDateTime.now().toString());
		
		for(FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(), LocalDateTime.now().toString());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(FileException.class)
	public ResponseEntity<StandardError> file(FileException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), LocalDateTime.now().toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(AmazonServiceException.class)
	public ResponseEntity<StandardError> amazonService(AmazonServiceException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(e.getStatusCode(), e.getMessage(), LocalDateTime.now().toString());
		return ResponseEntity.status(e.getStatusCode()).body(err);
	}
	
	@ExceptionHandler(AmazonClientException.class)
	public ResponseEntity<StandardError> amazonService(AmazonClientException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), LocalDateTime.now().toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(err);
	}
	@ExceptionHandler(AmazonS3Exception.class)
	public ResponseEntity<StandardError> amazonService(AmazonS3Exception e, HttpServletRequest request) {
		
		StandardError err = new StandardError(e.getStatusCode(), e.getMessage(), LocalDateTime.now().toString());
		return ResponseEntity.status(e.getStatusCode()).body(err);
	}
}
