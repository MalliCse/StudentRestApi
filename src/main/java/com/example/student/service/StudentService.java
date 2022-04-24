package com.example.student.service;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional(propagation= Propagation.REQUIRED)
	public Iterable<Student> getDetailsByName(String name)
	{
		
		System.out.println("Request cam to service layer of get method");
		stdrepo.findByStudentname(name);
//		throw new NoSuchElementException();
		
		return  stdrepo.findByStudentname(name);
	}
	
	public Iterable<Student> getDetailsByFatherName(String name)
	{
		
		System.out.println("Request cam to service layer of get method");
		
		return  stdrepo.getDetailsFather(name);
	}
	
	public Iterable<Student> getAllDetails()
	{
		
		System.out.println("Request cam to service layer of get method for all students");
		
		return  stdrepo.findAll();
	}
	
	@Transactional(propagation= Propagation.REQUIRED)
	public Iterable<Student> saveDetails(List<Student> student)
	{
		
		String name="";
		Iterable<Student> details = stdrepo.saveAll(student);
		for(Student details2:details)
		{
			name=details2.getStudentname();
		}
//		if(name.equals("Malli"))
//		{
//		throw new NoSuchElementException("Message");
//		}
//		Iterable<Student> details1 = stdrepo.saveAll(student);
		
		return details;
		
	}
	
	public Student updateDetails(Student student,Long id)
	{
		Student details = stdrepo.findById(id).get();
		details.setStudentname(student.getStudentname());
		//details.setFathername(student.getFathername());
		details.setMothername(student.getMothername());
		details.setGrade(student.getGrade());
		details.setAddress(student.getAddress());
		Student output = stdrepo.save(details);
		return output;
	}
	
	public String deleteDetails(Long id)
	{
		String output;
		Student std = stdrepo.findById(id).get();
		stdrepo.deleteById(id);
		output="Studen id : "+id+ " details are deleted successfully";
		
		
		return output;
	}

//	public Student updateDetailsPatially(Long id, Map<Object, Object> objectmapper) {
////		 String key="",value="";
//		 Student std=stdrepo.findById(id).get();
//		 objectmapper.forEach((k, v) -> {
//		 Field field = ReflectionUtils.findField(Student.class, k); // find field in the object class
//	     field.setAccessible(true); 
//	        ReflectionUtils.setField(field, std, v);
//			 
//		 });
//		 return stdrepo.save(std);
//	}
}
