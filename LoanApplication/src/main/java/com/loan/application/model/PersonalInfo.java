package com.loan.application.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PersonalInfo {
	
	@Column(name = "First_Name")
	String fName;
	
	@Column(name = "Last_Name")
	String lName;
	
	@Column(name = "Address")
	String address;
	
	@Column(name = "Gender")
	String gender;
	
	@Column(name = "DOB")
	@Temporal(TemporalType.DATE)
	Date dob;
	
	@Column(name = "Mobile")
	String mobile;
	
	@Id
	@Column(length = 10)
	String pan;
	
	String email;
	
	String currentCity;
	
	int pinCode;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PersonalInfo [fName=" + fName + ", lName=" + lName + ", address=" + address + ", gender=" + gender
				+ ", dob=" + dob + ", mobile=" + mobile + ", pan=" + pan + ", email=" + email + ", currentCity="
				+ currentCity + ", pinCode=" + pinCode + "]";
	}
	
	
}
