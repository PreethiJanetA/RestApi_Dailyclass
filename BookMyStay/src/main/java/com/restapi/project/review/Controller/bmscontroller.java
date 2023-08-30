package com.restapi.project.review.Controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.project.review.Model.bmsmodel;
import com.restapi.project.review.Repository.bmsrepo;
import com.restapi.project.review.Service.bmsservice;

@RestController              
public class bmscontroller 
{
    
//	@Autowired              
//	public bmsservice hs;
//	//Post the data//
//	@PostMapping("/postbms")     
//	public String postbms(@RequestBody bmsmodel br)
//	{
//		hs.savebms(br);
//		return "Data is filled Successfully";
//	}
//	//get the data//
//	@GetMapping("/getbms")      //handles HTTP GET requests and returns a list //
//	public List<bmsmodel> getbmsInfo()
//	{
//		return hs.getbms();
//	}
//	//get with id //
//	@GetMapping("/users/{userId}")   //If found, the object is returned in the response; otherwise, a 404 Not Found response is sent//
//	public ResponseEntity<?> getUserById(@PathVariable int userId)
//	{
//		Optional<bmsmodel> bms = hs.getUserid(userId);
//		if(bms!=null)
//		{
//			return ResponseEntity.ok(bms); //returns the customer's data if available//
//		}
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
//	}
//	//update the data//
//	@PutMapping("/putbms")   //The data is updated in the database//
//	public bmsmodel updatebmsInfo(@RequestBody bmsmodel ba)
//	{
//		return hs.updatebms(ba);
//	}
//	//update with id//
//	@PutMapping("/putbmsid/{id}") //If the update is successful, an OK response is sent; otherwise, a 404 Not Found response is sent//
//	public ResponseEntity<String> updatebmsInfor(@PathVariable int id,@RequestBody bmsmodel ba)
//	{
//		boolean updated=hs.updatebmsif(id,ba);
//		if(updated)
//		{
//			return ResponseEntity.ok("Booking with Id" + id + " updated successfully");
//		}
//		else
//		{
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking with Id"+id+" not Found");
//		}
//	}
//	//delete the data//
//	@DeleteMapping("/deletebmsif/{id}") //If the delete is successful, an OK response is sent; otherwise, a 404 Not Found response is sent//
//	//ok means Successfully//
//	public ResponseEntity<String> deletebmsInfo(@PathVariable int id)
//	{
//		boolean deleted=hs.deletebmsif(id);
//		if(deleted)
//		{
//			return ResponseEntity.ok("Booking with Id" + id + " deleted successfully");
//		}
//		else
//		{
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking with Id "+ id+" not Found");
//		}
//	}
//	//delete using path variable//
//	@DeleteMapping("/deletebms/{id}")  
//	public String removebms(@PathVariable("id") int bid)
//	{
//		br.deletebms(bid);
//		return "Booking with Id" + bid + " is deleted";
//	}
//	//delete using request//
//	@DeleteMapping("/byReqPam")
//	public String removeByRequestPam(@RequestParam("id") int id)
//	{
//		hs.deletebms(id);
//		return "Booking with Id" + id + " is deleted";
//	}
	@Autowired
	public bmsrepo br;
	
	@Autowired
	public bmsservice bs;
	
	@PostMapping("/post")
	public bmsmodel saveDetails(@RequestBody bmsmodel s)
	{
		return br.save(s);
	}
	@GetMapping("/get")
	public List<bmsmodel>getDetails()
	{
		return br.findAll();
	}
	@GetMapping("/sortAsc/{date}")
	public List<bmsmodel>sortby(@PathVariable("date") String cost)
	{
		return bs.sortByAsc(cost);
	}
	@GetMapping("/pg/{pgno}/{pgs}/{cost}")
	public List<bmsmodel>paginationAndSorting(@PathVariable("pgno")int pgno,@PathVariable("pgs")int pgs,@PathVariable("cost") String cost)
	{
		return bs.paginationAndSorting(pgno,pgs,cost);
	}
	
}

