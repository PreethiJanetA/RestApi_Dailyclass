package com.example.demo.Application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Application {

	@Value(value="${myName}")
	public String name;
	@Value(value="${age:18}")
	public int age;
	@Value(value="${regno:115}")
	public int regno;
	
	@GetMapping("/student")
	public String display()
	{
		return "My name is " + name + " Age is "+age + " Reg number is "+regno;
	}
	
}
