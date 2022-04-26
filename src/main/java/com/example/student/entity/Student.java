package com.example.student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	private String studentname;
	//@NotNull
	private String fathername;
	@NotNull
	private String mothername;
	@NotNull
	private int grade;
	@NotNull
	private String address;
	
	
	
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentname=" + studentname + ", fathername=" + fathername + ", mothername="
				+ mothername + ", grade=" + grade + ", address=" + address + "]";
	}
	public Student(long id, String studentname, String fathername, String mothername, int grade, String address) {
		super();
		this.id = id;
		this.studentname = studentname;
		this.fathername = fathername;
		this.mothername = mothername;
		this.grade = grade;
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
