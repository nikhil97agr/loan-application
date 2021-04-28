package com.loan.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.application.model.EligibilityParameters;
import com.loan.application.model.PersonalInfo;
import com.loan.application.repo.EligibilityParametersRepository;

@Service
public class EligibilityParametersService {
	@Autowired
	EligibilityParametersRepository repository;
	PersonalInfoService personalService;

	public boolean checkEligibility(EligibilityParameters eligibilityParam) {
		// TODO Auto-generated method stub
		eligibilityParam.getLoanAmt();
		PersonalInfo pInfo = personalService.getUser(eligibilityParam.getPan());
		return false;
	}
	
}
