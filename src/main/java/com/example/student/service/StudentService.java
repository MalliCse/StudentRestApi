package com.example.student.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.entity.Student;
import com.example.student.reporitory.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository stdrepo;
	
	public Student getDetails(long id)
	{
		
		System.out.println("Request cam to service layer of get method");
		
		return  stdrepo.findById(id).get();
	}
	
	public Iterable<Student> getDetailsByName(String name)
	{
		
		System.out.println("Request cam to service layer of get method");
		
		return  stdrepo.findByStudentname(name);
	}
	
	public Iterable<Student> getAllDetails()
	{
		
		System.out.println("Request cam to service layer of get method for all students");
		
		return  stdrepo.findAll();
	}
	
	public Iterable<Student> saveDetails(List<Student> student)
	{
		Iterable<Student> details = stdrepo.saveAll(student);
		return details;
		/*System.out.print(details);
		String message = "Student Created";
		return message;*/
	}
	
	public Student updateDetails(Student student,Long id)
	{
		Student details = stdrepo.findById(id).get();
		details.setStudentname(student.getStudentname());
		details.setFathername(student.getFathername());
		details.setMothername(student.getMothername());
		details.setGrade(student.getGrade());
		details.setAddress(student.getAddress());
		//Student output = stdrepo.save(details);
		return details;
	}
	
	public String deleteDetails(Long id)
	{
		String output;
		Student std = stdrepo.findById(id).get();
		stdrepo.deleteById(id);
		output="Studen id : "+id+ " details are deleted successfully";
		
		
		return output;
	}
}
