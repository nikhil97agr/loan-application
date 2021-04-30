package com.loan.application.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.application.log.GenerateLogs;
import com.loan.application.model.EligibilityParameters;
import com.loan.application.model.PersonalInfo;
import com.loan.application.model.ResidenceType;
import com.loan.application.model.Status;
import com.loan.application.repo.EligibilityParametersRepository;

@Service
public class EligibilityParametersService {
	@Autowired
	EligibilityParametersRepository repository;
	@Autowired
	PersonalInfoService personalService;
	@Autowired
	ResidenceTypeService residenceService;

	public Status checkEligibility(EligibilityParameters eligibilityParam) {
		// TODO Auto-generated method stub
		Status status = new Status(0, "Successfull");
		double amt = eligibilityParam.getLoanAmt();
		PersonalInfo pInfo = personalService.getUser(eligibilityParam.getPan());
		if(pInfo==null)
		{
			status.setStatusCode(11);
			status.setMessage("Pan information does not match any entry");
			return status;
		}
		
		ResidenceType rType = residenceService.getResidenceInfo(pInfo.getCurrentCity());
//		System.out.println(rType);

//		Period period = Period.between(pInfo.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
//		System.out.println(period);
		int age = calculateAge(pInfo.getDob(), new Date());
		System.out.println(age);
//		int age = period.getYears();
		int workex = eligibilityParam.getWorkExp();
		int cibil = eligibilityParam.getCibilScore();
		double rate = 11/1200f;
		double tenure = eligibilityParam.getMinTenure();
		long salary = eligibilityParam.getMonthlyIncome();
		long currentEmi = eligibilityParam.getCurrentEmi();
		if(age<21 || age>60)
		{
			status.setStatusCode(12);
			status.setMessage("Age criteria not met");
			return status;
		}
		if(workex<12)
		{
			status.setStatusCode(13);
			status.setMessage("Work experience less than 12 months");
			return status;
		}
		if(cibil<650)
		{
			status.setStatusCode(14);
			status.setMessage("Cibil score less than 650");
			return status;
		}

		tenure=tenure*12;
		
		double emi;
		emi=(amt*rate*Math.pow((1+rate), tenure))/(Math.pow((1+rate), tenure)-1);
		System.out.println(emi);
		
		int expense=0;
		String residenceType = eligibilityParam.getResidenceType();
		if(residenceType.equals("Paying Guest"))
		{
			expense = rType.getPayingGuest();
		}
		else if(residenceType.equals("Own by Self/Spouse/Parents"))
		{
			expense = rType.getOwn();
		}
		else if(residenceType.equals("Rented a flat"))
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
	
	public Status saveEligibility(EligibilityParameters eligibilityParameters)
	{
		Status status = new Status(1, "Data Not Saved");
		try {
		EligibilityParameters param = repository.save(eligibilityParameters);
		if(param!=null)
		{
			status.setStatusCode(0);
			status.setMessage("Successfull");
		}
		}catch(Exception ex)
		{
			return status;
		}
		return status;
	}
	
	private int calculateAge(Date first, Date last) {
		Calendar a = Calendar.getInstance(Locale.US);
		a.setTime(first);
		Calendar b = Calendar.getInstance(Locale.US);
		b.setTime(last);
	    int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
	    if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) || 
	        (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
	        diff--;
	    }
	    return diff;
	}

	public EligibilityParameters getParameters(String pan) {
		try {
			return repository.findById(pan).get();
		}catch(NoSuchElementException ex) {
			GenerateLogs.writeLog(ex.getMessage());
			return null;
		}catch(Exception ex) {
			GenerateLogs.writeLog(ex.getMessage());
			return null;
		}
	}
	
}
