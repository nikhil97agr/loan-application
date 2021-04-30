package com.loan.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.application.log.GenerateLogs;
import com.loan.application.model.EligibilityParameters;
import com.loan.application.model.OfferDetails;
import com.loan.application.model.PersonalInfo;
import com.loan.application.model.Status;
import com.loan.application.model.UserDetails;
import com.loan.application.service.EligibilityParametersService;
import com.loan.application.service.OffersService;
import com.loan.application.service.PersonalInfoService;

@RestController
public class PersonalInfoController {

	@Autowired
	PersonalInfoService service;
	@Autowired
	EligibilityParametersService service2;
	@Autowired
	OffersService service3;

	// request method to add new user in the database
	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public ResponseEntity<Status> addUser(@RequestBody PersonalInfo personalInfo) {
		System.out.println(personalInfo);
		Status status = new Status(0, "Successfull");
		try {
			if (service.checkUser(personalInfo.getPan())) {
				status.setStatusCode(2);
				status.setMessage("User already registered");
			} else if (service.addUser(personalInfo)) {
				status.setMessage("Successfull");
			} else {
				status.setMessage("Failure");
				status.setStatusCode(1);
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		} catch (Exception ex) {
			status.setStatusCode(1);
			status.setMessage(ex.getMessage());
			GenerateLogs.writeLog(ex.getMessage());
			System.out.println(ex);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/check-user", method = RequestMethod.GET)
	public ResponseEntity<Status> checkUser(@RequestParam("pan") String pan) {
		Status status = new Status(0, "Successfull");
		try {

			if (service.checkUser(pan)) {
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			} else {
				status.setStatusCode(1);
				status.setMessage("Invalid User");

			}
		} catch (Exception ex) {
			status.setStatusCode(1);
			status.setMessage(ex.getMessage());
			GenerateLogs.writeLog(ex.getMessage());
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/eligibility-check", method = RequestMethod.POST)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<Status> eligibilityIP(@RequestBody EligibilityParameters eligibilityParam) {
		System.out.println(eligibilityParam);
		Status status = new Status(1, "Failure");
		try {
			status = service2.checkEligibility(eligibilityParam);
			if (status.getStatusCode() == 0) {
				status = service2.saveEligibility(eligibilityParam);
				if (status.getStatusCode() == 0) {
//					status = service3.LoanOffers(eligibilityParam);
				}
			}
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		} catch (Exception ex) {
			GenerateLogs.writeLog(ex.getMessage());
			System.out.println(ex);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/fetch-details", method = RequestMethod.GET)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<Status> fetchDetails(@RequestParam("pan") String pan) {
		Status status = new Status(0, "Successfull");
		try {
			PersonalInfo info = service.getUser(pan);
			if(info==null)
			{
				status.setStatusCode(2);
				status.setMessage("User not found");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			EligibilityParameters param = service2.getParameters(pan);
			if(param==null)
			{
				status.setStatusCode(2);
				status.setMessage("Eligibility Details not found");
				return new ResponseEntity<Status>(status, HttpStatus.OK);
			}
			List<OfferDetails> offers = service3.loanOffers(param);
			UserDetails details = setDetails(info, param, offers);
			status.setStatusCode(10);
			status.setMessage(details);
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		} catch (Exception ex) {
			GenerateLogs.writeLog(ex.getMessage());
			status.setStatusCode(1);
			status.setMessage("Failure");
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}

	private UserDetails setDetails(PersonalInfo info, EligibilityParameters param, List<OfferDetails> offers) {
		UserDetails details = new UserDetails();
		details.setName(info.getfName()+" "+info.getlName());
		details.setCompanyName(param.getCompanyName());
		details.setEmail(info.getEmail());
		details.setCurrentCity(info.getCurrentCity());
		details.setLoanAmt(param.getLoanAmt());
		details.setOffers(offers);
		
		return details;
	}
}
