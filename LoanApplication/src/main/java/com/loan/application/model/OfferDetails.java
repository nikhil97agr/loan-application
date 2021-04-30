package com.loan.application.model;

public class OfferDetails {
	double tenure;
	double interest;
	double emi;
	
	
	public OfferDetails() {
		super();
	}
	public OfferDetails(double tenure, double interest, double emi) {
		super();
		this.tenure = tenure;
		this.interest = interest;
		this.emi = emi;
	}
	public double getTenure() {
		return tenure;
	}
	public void setTenure(double tenure) {
		this.tenure = tenure;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	@Override
	public String toString() {
		return "OfferDetails [tenure=" + tenure + ", interest=" + interest + ", emi=" + emi + "]";
	}
	
	
	
}
