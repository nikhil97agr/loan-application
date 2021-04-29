package com.loan.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.loan.application.log.GenerateLogs;
import com.loan.application.model.LoanEligibilityParam;
import com.loan.application.repo.LoanEligibilityRepository;

@Service
public class LoanEligibityService {
	
	@Autowired
	LoanEligibilityRepository repository;
	
	
	public LoanEligibilityParam findLaonEligibility(String loanType) {
		try {
			LoanEligibilityParam data = repository.findById(loanType).get();
			return data;
			
		}catch(Exception ex) {
			GenerateLogs.writeLog(ex.getMessage());
			return null;
		}
	}
}
