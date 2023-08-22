package com.example.demo.jsonignorance;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
public class jsonignorance {

	public int studentId;
	public String studentname;
	@JsonIgnore
	public int age;
	
	public jsonignorance()
	{
		
	}

	public jsonignorance(int studentId, String studentname, int age) {
		super();
		this.studentId = studentId;
		this.studentname = studentname;
		this.age = age;
	}
	
}
