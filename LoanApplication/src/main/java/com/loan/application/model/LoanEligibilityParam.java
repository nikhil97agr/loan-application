package com.loan.application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoanEligibilityParam {
	
	@Id
	String type;
	
	int minAge;
	
	int maxAge;
	
	int workExp;
	
	int cibilScore;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public int getWorkExp() {
		return workExp;
	}

	public void setWorkExp(int workExp) {
		this.workExp = workExp;
	}

	public int getCibilScore() {
		return cibilScore;
	}

	public void setCibilScore(int cibilScore) {
		this.cibilScore = cibilScore;
	}
	
	
}
