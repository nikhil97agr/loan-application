package com.loan.application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LaonType {

	@Id
	String type;
	
	int interest;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}
	
	
}
