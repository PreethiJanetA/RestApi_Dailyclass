package com.restapi.project.review.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity                      
@Table(name="booking")      

public class bmsmodel {
  
	@Id                        
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bid")
	private long bid;
	private int userId;      
	private String date;
	private int guestcount;
	private int cost;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_bid" , referencedColumnName ="bid")
	private List<paymentmodel> paymentmodel;
	public long getBid() {
		return bid;
	}
	public void setBid(long bid) {
		this.bid = bid;
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
	public List<paymentmodel> getPaymentmodel() {
		return paymentmodel;
	}
	public void setPaymentmodel(List<paymentmodel> paymentmodel) {
		this.paymentmodel = paymentmodel;
	}
	
	
	
}
