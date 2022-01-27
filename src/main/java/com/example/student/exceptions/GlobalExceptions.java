package com.example.student.exceptions;
import java.util.Date;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.student.controller.StudentController;
import com.example.student.entity.ExceptionEntity; 

@ControllerAdvice
public class GlobalExceptions {

	Logger logger=LoggerFactory.getLogger(GlobalExceptions.class);
	
	@ExceptionHandler(NoSuchElementException.class)  
	public final ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex, WebRequest request)  
	{  
	//creating exception response structure  
		logger.error("NoSuchElement Exception is caught");
	ExceptionEntity exceptionResponse= new ExceptionEntity(new Date(),"No Value Is ot Present In System, Please search for valid id", request.getDescription(false));  
	//returning exception structure and specific status   
	System.out.println("Exception is being processed");
	return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);  
	}
	
	
}
