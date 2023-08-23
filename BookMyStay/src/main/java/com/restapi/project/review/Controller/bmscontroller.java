package com.restapi.project.review.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.project.review.Model.bmsmodel;
import com.restapi.project.review.Service.bmsservice;

@RestController              //model view controller that handles HTTPS request,output in json//
public class bmscontroller {
    
	@Autowired               // controller to interact with the service to perform business logic//
	public bmsservice hs;
	//Post the data//
	@PostMapping("/postbms")     //handles HTTPS request to json request// //The data is saved to the database using the savebms() method from the service//
	public String postbms(@RequestBody bmsmodel br)
	{
		hs.savebms(br);
		return "Data is filled Successfully";
	}
	//get the data//
	@GetMapping("/getbms")      //handles HTTP GET requests and returns a list //
	public List<bmsmodel> getbmsInfo()
	{
		return hs.getbms();
	}
	//get with id //
	@GetMapping("/users/{userId}")   //If found, the object is returned in the response; otherwise, a 404 Not Found response is sent//
	public ResponseEntity<?> getUserById(@PathVariable int userId)
	{
		Optional<bmsmodel> bms = hs.getUserid(userId);
		if(bms!=null)
		{
			return ResponseEntity.ok(bms); //returns the customer's data if available//
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
	}
	//update the data//
	@PutMapping("/putbms")   //The data is updated in the database//
	public bmsmodel updatebmsInfo(@RequestBody bmsmodel ba)
	{
		return hs.updatebms(ba);
	}
	//update with id//
	@PutMapping("/putbmsid/{id}") //If the update is successful, an OK response is sent; otherwise, a 404 Not Found response is sent//
	public ResponseEntity<String> updatebmsInfor(@PathVariable int id,@RequestBody bmsmodel ba)
	{
		boolean updated=hs.updatebmsif(id,ba);
		if(updated)
		{
			return ResponseEntity.ok("Booking with Id" + id + " updated successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking with Id"+id+" not Found");
		}
	}
	//delete the data//
	@DeleteMapping("/deletebmsif/{id}") //If the delete is successful, an OK response is sent; otherwise, a 404 Not Found response is sent//
	//ok means Successfully//
	public ResponseEntity<String> deletebmsInfo(@PathVariable int id)
	{
		boolean deleted=hs.deletebmsif(id);
		if(deleted)
		{
			return ResponseEntity.ok("Booking with Id" + id + " deleted successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking with Id "+ id+" not Found");
		}
	}
	//delete using path variable//
	@DeleteMapping("/deletebms/{id}")  
	public String removebms(@PathVariable("id") int bid)
	//Pathvariable = used to extract the value of the template variables and assign their value to a method variable//
	{
		hs.deletebms(bid);
		return "Booking with Id" + bid + " is deleted";
	}
	//delete using request//
	@DeleteMapping("/byReqPam")
	public String removeByRequestPam(@RequestParam("id") int id)
	{
		hs.deletebms(id);
		return "Booking with Id" + id + " is deleted";
	}
}
//It interacts with the bmsservice to perform CRUD operations on the data //
//and returns appropriate responses to the client//
