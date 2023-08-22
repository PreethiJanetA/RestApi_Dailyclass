package com.example.day5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day5.model.HotelModel;
import com.example.day5.repository.HotelRepo;

@Service
public class HotelService {

	@Autowired
	public HotelRepo hrepo;
	
	//post the data//
	public String saveHotel(HotelModel h)
	{
		hrepo.save(h);
		return "Data is saved to database";
	}
	
	//get the data//
	public List<HotelModel> getHotel()
	{
		return hrepo.findAll();
		
	}
	//get with id//
		public Optional<HotelModel>getUserid(int userid)
		{
			Optional<HotelModel> hotel = hrepo.findById(userid);
			if(hotel.isPresent())
			{
				return hotel;
			}
			return null;
		}
	
	//update the data(put)//
	public HotelModel updateHotel(HotelModel hm)
	{
		return hrepo.saveAndFlush(hm);
	}
	
	//delete mapping//
	public void deleteHotel(int id)
	{
		System.out.println("Delete");
		hrepo.deleteById(id);
	}
	
	//delete if id is present//
	public boolean deleteHotelif(int hotelId)
	{
		if(hrepo.existsById(hotelId))
			hrepo.deleteById(hotelId);
		   return false;
	}
	
	//put data if id present//
	public boolean updateHotelif(int hotelId,HotelModel hm)
	{
		if(hrepo.existsById(hotelId)){
			hrepo.save(hm);
			return true;
		}
		return false;
	}
	
}
