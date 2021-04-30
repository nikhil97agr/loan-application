package com.loan.application.model;

import java.util.List;


/////Model of OfferDetails and userdetails combined for sending the object to the front end

public class UserDetails {
	String name;
	
	String email;
	
	String companyName;
	
	String currentCity;
	
	long loanAmt;
	
	List<OfferDetails> offers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public long getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(long loanAmt) {
		this.loanAmt = loanAmt;
	}

	public List<OfferDetails> getOffers() {
		return offers;
	}

	public void setOffers(List<OfferDetails> offers) {
		this.offers = offers;
	}

	@Override
	public String toString() {
		return "UserDetails [name=" + name + ", email=" + email + ", companyName=" + companyName + ", currentCity="
				+ currentCity + ", loanAmt=" + loanAmt + ", offers=" + offers + "]";
	}
	
	
	
	
}
