package com.example.demo.welcome.day1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class color {

	@GetMapping("/getMyfav")
	public String getMyfav()
	{
		String color="My Favourite color is Blue!!!";
		return color;
	}
}
