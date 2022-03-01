package com.example.student.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.student.entity.Student;
import com.example.student.reporitory.StudentRepository;


@SpringBootTest
class StudentService1  {

	@InjectMocks
	private StudentService std1;
	
	@Mock
	private StudentRepository stdrep;
	
	Student s;
	
	@Disabled
	@Test
	public void test() throws NoSuchElementException {
		//String name="Malli";
		long id=1;
		s=new Student(1,"Malli","Vijay","Rani",10,"Veluru");
		System.out.print(s);
		List<Student> stud=new ArrayList<Student>();
		stud.add(s);
		Mockito.when(stdrep.findById(id).get()).thenReturn(s);
		assertEquals(std1.getDetails(id),s);
	}
	
	@Test
	public void test1() throws NoSuchElementException {
		String name="Malli";
		long id=1;
		s=new Student(1,"Malli","Vijay","Rani",10,"Veluru");
		System.out.print(s);
		List<Student> stud=new ArrayList<Student>();
		stud.add(s);
		Mockito.when(stdrep.findByStudentname(name)).thenReturn(stud);
		assertEquals(std1.getDetailsByName(name),stud);
	}

	

}
