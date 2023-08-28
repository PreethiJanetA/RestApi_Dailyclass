package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.UserRepo;


@RestController
public class UserController {
	
	@Autowired
	public UserRepo Urepo;
	
	@PostMapping("/post")
	public Student saveDetails(@RequestBody Student s) 
	{
		return Urepo.save(s);
	}
	
	@GetMapping("get")
	public List<Student> getDetails()
	{
		return  Urepo.findAll();
	}
	
}
