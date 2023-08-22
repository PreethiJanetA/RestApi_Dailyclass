package com.example.demo.welcome.day1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {

	@GetMapping("/welcome")
	public String welcome()
	{
		return "Welcome Friends !";
	}
}
