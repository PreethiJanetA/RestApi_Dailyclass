package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.tmodel;
import com.example.demo.service.tservice;

@RestController
public class tcontroller {

	@Autowired
	public tservice tserv;
	//post Mapping//
	@PostMapping("/postt")
	public String postt(@RequestBody tmodel tr)
	{
		tserv.savet(tr);
		return "Happy to see you";
	}
	//get Mapping //
	@GetMapping("/gett")
	public List<tmodel> gettInfo()
	{
		return tserv.gett();
	}
	
	@GetMapping("/anime/{id}")
	public ResponseEntity<?> getuserById(@PathVariable int id)
	{
		Optional<tmodel> t=tserv.getUserid(id);
		if(t!=null)
		{
			return ResponseEntity.ok(t);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
	}
}
