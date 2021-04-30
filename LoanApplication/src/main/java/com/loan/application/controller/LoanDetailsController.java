package com.loan.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loan.application.log.GenerateLogs;
import com.loan.application.model.LoanDetails;
import com.loan.application.model.Status;
import com.loan.application.service.LoanDetailsService;

/////LoanDetailsController for updating the loan information in the LoanDetails table that is fetch from the UI
@Controller
public class LoanDetailsController {
	
	@Autowired
	LoanDetailsService service;
	
	@RequestMapping(value = "/update-loan", method = RequestMethod.POST)
	public ResponseEntity<Status> updateLoan(@RequestBody LoanDetails loanDetails){
		Status status = new Status(1, "Failure");
		
		try {
			status = service.saveDetails(loanDetails);
		}catch(Exception ex) {
			GenerateLogs.writeLog(ex.getMessage());
			return new ResponseEntity<Status>(status, HttpStatus.OK);
		}
		return new ResponseEntity<Status>(status, HttpStatus.OK);
	}
	
}
