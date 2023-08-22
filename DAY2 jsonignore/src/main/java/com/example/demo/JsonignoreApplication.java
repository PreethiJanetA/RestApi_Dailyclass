package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.jsonprop.jsonprop;
//import com.example.demo.jsonignorance.jsonignorance;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@SpringBootApplication
public class JsonignoreApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(JsonignoreApplication.class, args);
//		jsonignorance obj = new jsonignorance(1, "Janet" ,20);
//		ObjectMapper map = new ObjectMapper();
//		String str=map.writeValueAsString(obj);
//		System.out.println(str);
		
		jsonprop i= new jsonprop(115,"Janet",20);
		ObjectMapper map=new ObjectMapper();
		String str=map.writeValueAsString(i);
		System.out.print(str);
		
	}

}
