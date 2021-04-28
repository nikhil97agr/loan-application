package com.loan.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.application.log.GenerateLogs;
import com.loan.application.model.PersonalInfo;
import com.loan.application.model.Status;
import com.loan.application.service.PersonalInfoService;
		
@RestController
public class PersonalInfoController {

	@Autowired
	PersonalInfoService service;

	//request method to add new user in the database
	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	@ResponseBody
	public Status addUser(@RequestBody PersonalInfo personalInfo){
		System.out.println(personalInfo);
		Status status = new Status(0, "Successfull");
		try {
			if (service.addUser(personalInfo)) {
				status.setMessage("Successfull");
			}
			else {
				status.setMessage("Failure");
				status.setStatusCode(1);
			}
			return status;
		} catch (Exception ex) {
			status.setStatusCode(1);
			status.setMessage(ex.getMessage());
			GenerateLogs.writeLog(ex.getMessage());
			System.out.println(ex);	
			return status;
		}
	}
	
	@RequestMapping(value = "/check-user", method = RequestMethod.GET)
	@ResponseBody
	public Status checkUser(@RequestParam("pan")String pan) {
		Status status = new Status(0, "Successfull");
		try {
			
			if(service.checkUser(pan))
			{
				return status;
			}
			else
			{
				status.setStatusCode(1);
				status.setMessage("Invalid User");
				
			}
		}catch(Exception ex)
		{
			status.setStatusCode(1);
			status.setMessage(ex.getMessage());
			GenerateLogs.writeLog(ex.getMessage());
			return status;
		}
		return status;
	}
}
