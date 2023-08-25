package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.car;
import com.example.demo.service.Apiservice;

@RestController
public class Apicontroller {

	@Autowired
	public Apiservice cserv;
	//get mapping//
	@GetMapping("/getcar")
	public List<car> getcarInfo()
	{
		return cserv.getcar();
	}
	//put Mapping//
	@PutMapping("/putcar")
	public  car updatecarInfo(@RequestBody car ca)
	{
		return cserv.updatecar(ca);
	}
	@GetMapping("/getrows")
	 public List<car> getAllRows()
	 {
		 return cserv.getAllrows();
	 }
	 //get specific data
	 @GetMapping("/getSpecific/{Carname}/{CarType}")
	 public List<car> getSpec(@PathVariable("Carname") String Carname,@PathVariable("CarType") String CarType)
	 {
		 return cserv.getSpecrows(Carname,CarType);
	 }
	 
	 @GetMapping("/getn/{name}")
		public List<car>getname(@PathVariable("Carname") String Carname)
		{
			return cserv.getByName(Carname);
		}
		
		@DeleteMapping("/deleterow/{id}")
		public String deleteRow(@PathVariable("id") int id)
		{
			return cserv.deleteRowByid(id)+" deleted successfully";
		}
		//UPDATE
		@PutMapping("/updaterow/{color}/{id}")
		public String updateinfo(@PathVariable("CarType") String CarType,@PathVariable("id") int id)
		{
			return cserv.updateRow(CarType,id)+" rows updated successfully";
		}

}
