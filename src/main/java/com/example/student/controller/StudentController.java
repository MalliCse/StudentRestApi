package com.example.student.controller;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.entity.ExceptionEntity;
import com.example.student.entity.Student;
import com.example.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService std1;
	Logger logger=LoggerFactory.getLogger(StudentController.class);
	
	@GetMapping("/getdetails/{id}")
	public Student getStudentDetails(@PathVariable Long id)
	{
		logger.info("Get Request For A Studet id {} came",id);
		logger.info("Get Request is forwarded to service layer");

    	return std1.getDetails(id);
		
		
		
	}
	
	@GetMapping("/getdetailsbyname")
	public Iterable<Student> getStudentDetailsByName(@RequestParam String name)
	{
		logger.info("Get Request For A Studet Name {} came",name);
		logger.info("Get Request is forwarded to service layer");

    	return std1.getDetailsByName(name);
		
		
		
	}
	
	@GetMapping("/getalldetails")
	public Iterable<Student> getAllStudentDetails()
	{
		logger.info("Get all Request Came For All Students");
		logger.info("Get All Request is forwarded to service layer");


    	return std1.getAllDetails();
		
		
		
	}
	
	@PostMapping("/insertstudent")
	public ResponseEntity<Object> storeStudentDetails(@RequestBody @Valid List<Student> student)
	{
		logger.info("Post Request Came For All Students");
		logger.info("Post Request is forwarded to service layer");

    	Iterable<Student> std = std1.saveDetails(student);
    	String message="Details Are Saved";
    	ExceptionEntity exceptionResponse= new ExceptionEntity(new Date(),message,"Success");  
    	
    	return new ResponseEntity(exceptionResponse,HttpStatus.OK);
		
		
	}
	
	@PutMapping("/updatestudent/{id}")
	public Student updateStudentDetails(@RequestBody @Valid Student student,@PathVariable Long id)
	{
		logger.info("Put Request Came For All Students");
		logger.info("Put Request is forwarded to service layer");

    	return std1.updateDetails(student,id);
	}
	
	@DeleteMapping("/deletestudent/{id}")
	public String deleteStudentDetails(@PathVariable Long id)
	{
		logger.info("Delete Request Came For All Students");
		logger.info("Delete Request is forwarded to service layer");

    	return std1.deleteDetails(id);
		
		
		
	}
	
}