package com.loan.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


/////Model of LoanDetails and creation of LoanDetails table
@Entity
public class LoanDetails {
	@Id
	@Column(length = 10)
	String pan;
	
	String name;
	
	double loanAmt;
	
	double emi;
	
	
	int tenure;

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(double loanAmt) {
		this.loanAmt = loanAmt;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "LoanDetails [pan=" + pan + ", fName=" + name + ", loanAmt=" + loanAmt + ", emi=" + emi + ", tenure="
				+ tenure + "]";
	}
	
}
