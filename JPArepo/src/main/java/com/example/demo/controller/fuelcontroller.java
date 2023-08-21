package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.petrolbunk;
import com.example.demo.service.Fuelservice;

@RestController
public class fuelcontroller {
 
	  @Autowired
	  Fuelservice f;
	  @PostMapping("/saveFuel")
	  public petrolbunk saveFuelStationde(@RequestBody petrolbunk pb)
	  {
		  return f.saveDetails(pb);
	  }
	  @GetMapping("/getFuel")
	  public List<petrolbunk> getFuelStationde()
	  {
		  return f.getDetails();
	  }
	
}
