package com.loan.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.application.log.GenerateLogs;
import com.loan.application.model.LoanDetails;
import com.loan.application.model.Status;
import com.loan.application.repo.LoanDetailsRepo;

@Service
public class LoanDetailsService {
	
	@Autowired
	LoanDetailsRepo repository;
	
	public Status saveDetails(LoanDetails loanDetails) {
		Status status = new Status(1, "Failure");
		try {
			LoanDetails details = repository.save(loanDetails);
			if(details!=null)
			{
				status.setStatusCode(0);
				status.setMessage("Successfull");
			}
			
		}catch(Exception ex) {
			GenerateLogs.writeLog(ex.getMessage());
			return status;
		}
		return status;
	}

}
