package com.loan.application.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.application.log.GenerateLogs;
import com.loan.application.model.PersonalInfo;
import com.loan.application.repo.PersonalInfoRepository;

@Service
public class PersonalInfoService {

	@Autowired
	PersonalInfoRepository repository;

	// insert the user in the database
	public boolean addUser(PersonalInfo personalInfo) {
		try {
			repository.saveAndFlush(personalInfo);

		} catch (Exception ex) {
			return false;
		}

		return true;
	}

	public boolean checkUser(String pan) {
		boolean status = repository.existsById(pan);
		return status;
	}

	public PersonalInfo getUser(String pan) {
		try {
			PersonalInfo user = repository.findById(pan).get();
			return user;
		} catch (NoSuchElementException ex) {
			GenerateLogs.writeLog(ex.getMessage());
			return null;
		} catch (Exception ex) {
			return null;
		}
	}

}
