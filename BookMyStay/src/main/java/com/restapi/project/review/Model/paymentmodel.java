package com.restapi.project.review.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class paymentmodel
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long pid;
	private long paymentId;
	private int paymentamount;
	private String paymentstatus;
	private String paymentmethod;
//	@ManyToOne
//	@JoinColumn(name = "bid") // The name of the foreign key column in paymentmodel table
//	private bmsmodel booking;
	
	public long getPaymentId() {
		return paymentId;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	public int getPaymentamount() {
		return paymentamount;
	}
	public void setPaymentamount(int paymentamount) {
		this.paymentamount = paymentamount;
	}
	public String getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	
}
