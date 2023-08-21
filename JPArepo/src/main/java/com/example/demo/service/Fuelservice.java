package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.petrolbunk;
import com.example.demo.repo.fuelrepo;

@Service
public class Fuelservice {

	@Autowired 
	public fuelrepo frepo;
	
	//Post the data//
	
	public petrolbunk saveDetails(petrolbunk p)
	{
		return frepo.save(p);
	}
	
	//get the data//
	
	public List<petrolbunk> getDetails()
	{
		return frepo.findAll();
	}
}
