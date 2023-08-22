package com.example.demo.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class value {
       
	   @Value("115")
	   public int regno;
	   @Value("Janet")
	   public String name;
	   
	   @RequestMapping("/display")
	   public String display()
	   {
		   return "My name is "+ name +" Reg number is "+ regno;
	   }
	
	
}
