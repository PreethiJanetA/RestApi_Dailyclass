package com.example.day5.controller;

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

import com.example.day5.model.HotelModel;
import com.example.day5.service.HotelService;

@RestController
public class HotelController {

	@Autowired
	public HotelService hserv;
	
	//post mapping//
	@PostMapping("/postHotel")
	public String postHotel(@RequestBody HotelModel hr)
	{
		hserv.saveHotel(hr);
		return "Data is  saved to the database";
	}
	
	
	
	//get Mapping//
	@GetMapping("/getHotel")
	public List<HotelModel> getHotelInfo()
	{
		return hserv.getHotel();
	}
	//get mapping with id//
		@GetMapping("/users/{userId}")
		public ResponseEntity<?> getUserById(@PathVariable int userid)
		{
		Optional<HotelModel> hotel = hserv.getUserid(userid);
		
		if(hotel!=null)
		{
			return ResponseEntity.ok(hotel);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not avaliable with Id");
		}
	
		
		
	//put mapping//
	@PutMapping("/putHotel")
	public HotelModel updateHotelInfo(@RequestBody HotelModel ha)
	{
		return hserv.updateHotel(ha);
	}
	//put mapping with id//
		@PutMapping("/putHotelif/{id}")
		public ResponseEntity<String> updateHotelInfor(@PathVariable int id,@RequestBody HotelModel ha)
		{
			boolean updated = hserv.updateHotelif(id, ha);
			if(updated)
			{
				return ResponseEntity.ok("Hotel with Id" + id+" updated successfully");//ok means success//
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with Id " + id + " not found and not updated");
			}
		}
	
		
		
	//delete mapping with if condition//
	@DeleteMapping("/deleteHotelif/{id}")
	public ResponseEntity<String> deleteHotelInfo(@PathVariable int id)
	{
		boolean deleted = hserv.deleteHotelif(id);
		if(deleted)
		{
			return ResponseEntity.ok("Hotel with Id" + id+" deleted successfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with Id " + id + " not found");
		}
	}
	
	
	// delete mapping using path variable//
	@DeleteMapping("/deleteHotel/{id}")
	public String removeHotel(@PathVariable("id") int hid)
	{
		hserv.deleteHotel(hid);
		return "Hotel with Id " +hid+" is deleted";
	}
	
	
	//delete mapping using request parm//
	@DeleteMapping("/byReqPam")
	public String removeByRequestPam(@RequestParam("id") int id)
	{
		hserv.deleteHotel(id);
		return "Hotel with Id " +id+" is deleted";
	}
	
}

