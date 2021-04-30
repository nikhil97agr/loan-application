package com.loan.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoanDetails {
	@Id
	@Column(length = 10)
	String pan;
	
	String fName;
	
	double loanAmt;
	
	double emi;
	
	int tenure;

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
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
		return "LoanDetails [pan=" + pan + ", fName=" + fName + ", loanAmt=" + loanAmt + ", emi=" + emi + ", tenure="
				+ tenure + "]";
	}
	
}
