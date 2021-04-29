package com.loan.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.application.model.EligibilityParameters;
import com.loan.application.model.PersonalInfo;
import com.loan.application.model.Status;
import com.loan.application.repo.EligibilityParametersRepository;

@Service
public class EligibilityParametersService {
	@Autowired
	EligibilityParametersRepository repository;
	PersonalInfoService personalService;

	public Status checkEligibility(EligibilityParameters eligibilityParam) {
		// TODO Auto-generated method stub
		Status status = new Status(0, "Successfull");
		eligibilityParam.getLoanAmt();
		PersonalInfo pInfo = personalService.getUser(eligibilityParam.getPan());
		if(pInfo==null)
		{
			status.setStatusCode(11);
			status.setMessage("Pan information does not match any entry");
			return status;
		}
		
		
		return status;
	}
	
}
