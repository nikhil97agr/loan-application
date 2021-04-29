package com.loan.application.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.application.model.EligibilityParameters;
import com.loan.application.model.PersonalInfo;
import com.loan.application.model.ResidenceType;
import com.loan.application.model.Status;
import com.loan.application.repo.EligibilityParametersRepository;

@Service
public class EligibilityParametersService {
	@Autowired
	EligibilityParametersRepository repository;
	PersonalInfoService personalService;
	ResidenceTypeService residenceService;

	public Status checkEligibility(EligibilityParameters eligibilityParam) {
		// TODO Auto-generated method stub
		Status status = new Status(0, "Successfull");
		long amt = eligibilityParam.getLoanAmt();
		PersonalInfo pInfo = personalService.getUser(eligibilityParam.getPan());
		if(pInfo==null)
		{
			status.setStatusCode(11);
			status.setMessage("Pan information does not match any entry");
			return status;
		}
		
		ResidenceType rType = residenceService.getResidenceInfo(pInfo.getCurrentCity());
		
		Period period = Period.between(pInfo.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
		int age = period.getYears();
		int workex = eligibilityParam.getWorkExp();
		int cibil = eligibilityParam.getCibilScore();
		int rate = 11;
		int tenure = eligibilityParam.getMinTenure();
		long salary = eligibilityParam.getMonthlyIncome();
		long currentEmi = eligibilityParam.getCurrentEmi();
		
		if(age<21 || age>60)
		{
			status.setStatusCode(12);
			status.setMessage("age criteria not met");
			return status;
		}
		if(workex<12)
		{
			status.setStatusCode(13);
			status.setMessage("work experience less than 12 months");
			return status;
		}
		if(cibil<650)
		{
			status.setStatusCode(14);
			status.setMessage("cibil score less than 650");
			return status;
		}
		
		tenure=tenure*12;
		
		double emi;
		emi=amt*rate*Math.pow((1+rate), tenure)/(Math.pow((1+rate), tenure)-1);
		System.out.println(emi);
		
		int expense=0;
		String residenceType = eligibilityParam.getResidenceType();
		if(residenceType.equals("payingGuest"))
		{
			expense = rType.getPayingGuest();
		}
		else if(residenceType.equals("own"))
		{
			expense = rType.getOwn();
		}
		else if(residenceType.equals("rent"))
		{
			expense = rType.getRent();
		}
		
		long savings = salary-currentEmi;
		savings = (long) (savings - expense);
		savings = (long) (savings - emi);
		
		if(savings<=10000)
		{
			status.setStatusCode(15);
			status.setMessage("Monthly savings less than 10001");
			return status;
		}
		
		
		return status;
	}
	
}
