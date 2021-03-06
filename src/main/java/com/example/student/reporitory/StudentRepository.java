package com.example.student.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


	 public Iterable<Student> findByStudentname(String studentname);
	 
	 @Query(value="select * from Student where fathername=:name",nativeQuery=true)
	 public  Iterable<Student> getDetailsFather(String name);
}
