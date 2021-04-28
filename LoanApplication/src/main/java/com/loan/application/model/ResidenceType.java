package com.loan.application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ResidenceType {

	@Id
	String city;

	int own;

	int rent;

	int payingGuest;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getOwn() {
		return own;
	}

	public void setOwn(int own) {
		this.own = own;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public int getPayingGuest() {
		return payingGuest;
	}

	public void setPayingGuest(int payingGuest) {
		this.payingGuest = payingGuest;
	}
	
	
	
	
	
}
