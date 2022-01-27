package com.example.student.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.student.entity.Student;
import com.example.student.reporitory.StudentRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentService1 {

	@Autowired
	private StudentService std1;
	
	@MockBean
	private StudentRepository stdrep;
	
	@BeforeEach
	public void setUp()
	{
		long id=1;
		Student s=new Student(id,"Malli","Vijay","Rani",10,"Veluru");
		Mockito.when(stdrep.findById(id).get()).thenReturn(s);
	}
	
	@Test
	void test() {
		long id=1;
		 Student stud=std1.getDetails(id);
		 System.out.print(stud.getId());
		 assertNotEquals(id,stud.getId());
	}

	

}
