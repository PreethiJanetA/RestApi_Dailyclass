package com.example.demo.jsonprop;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@JsonIgnoreProperties(value= {"stid","name"))
public class jsonprop {
	
	public int stid;
	public String name;
	public int age;
	
	public jsonprop()
	{
		
	}
	public jsonprop(int stid, String name, int age) {
		super();
		this.stid = stid;
		this.name = name;
		this.age = age;
	}
	

}
