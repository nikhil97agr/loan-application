package com.loan.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EligibilityParameters {
	
	@Id
	@Column(length = 10)
	String pan;
	
	String companyName;
	
	String employementType;
	
	long monthlyIncome;
	
	long loanAmt;
	
	long currentEmi;
	
	int currentTenure;
	
	@Column(name = "work_exp_in_months")
	int workExp;
	
	String residenceType;
	
	String loanPurpose;
	
	int cibilScore;
	
	int minTenure;

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmployementType() {
		return employementType;
	}

	public void setEmployementType(String employementType) {
		this.employementType = employementType;
	}

	public long getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(long monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}	

	public long getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(long loanAmt) {
		this.loanAmt = loanAmt;
	}

	public long getCurrentEmi() {
		return currentEmi;
	}

	public void setCurrentEmi(long currentEmi) {
		this.currentEmi = currentEmi;
	}

	public int getCurrentTenure() {
		return currentTenure;
	}

	public void setCurrentTenure(int currentTenure) {
		this.currentTenure = currentTenure;
	}

	public int getWorkExp() {
		return workExp;
	}

	public void setWorkExp(int workExp) {
		this.workExp = workExp;
	}

	public String getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}

	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	public int getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}

	public int getMinTenure() {
		return minTenure;
	}

	public void setMinTenure(int minTenure) {
		this.minTenure = minTenure;
	}
	
	
}
