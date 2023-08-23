package com.restapi.project.review.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity                      //represents a table stored in a database//
@Table(name="Property")      //entity should be mapped to a database table named "Property"//

public class bmsmodel {
  
	@Id                        // marks primary key of the entity//
	@GeneratedValue(strategy = GenerationType.IDENTITY) //it indicates that the primary keyvalues will be automatically generated using an identity column strategy//
	private int bookingId;
	private int userId;
	@Column(name="bms")       //maps it to a database column named "bms"//
	private String date;
	private int guestcount;
	private int cost;
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getGuestcount() {
		return guestcount;
	}
	public void setGuestcount(int guestcount) {
		this.guestcount = guestcount;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
	
}
