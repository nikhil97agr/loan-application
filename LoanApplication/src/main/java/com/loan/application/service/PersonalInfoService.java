package com.loan.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.application.model.PersonalInfo;
import com.loan.application.repo.PersonalInfoRepository;

@Service
public class PersonalInfoService {

	@Autowired
	PersonalInfoRepository repository;
	
	//insert the user in the database
	public boolean addUser(PersonalInfo personalInfo) {
		try {
			repository.saveAndFlush(personalInfo);
			
		}catch(Exception ex) {
			return false;
		}
		
		return true;
	}
	
	public boolean checkUser(String pan) {
		boolean status = repository.existsById(pan);
		return status;
	}
}
