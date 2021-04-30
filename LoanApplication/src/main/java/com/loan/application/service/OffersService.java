package com.loan.application.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.loan.application.model.EligibilityParameters;


public class OffersService {
	
	@Autowired
	PersonalInfoService personalService;


	public double[] LoanOffers(EligibilityParameters eligibilityParam) {
		// TODO Auto-generated method stub
		double arr[]=new double[9];
		double amt = eligibilityParam.getLoanAmt();
		double rate = 11/1200f;
		double tenure = eligibilityParam.getMinTenure();
		
		tenure=tenure*12;
		
		double emi;
		
		for(int i=0;i<9;i++)
		{
			emi=(amt*rate*Math.pow((1+rate), tenure))/(Math.pow((1+rate), tenure)-1);
			System.out.println(emi);
			
			double interest = amt-emi;
			
			arr[i++]=tenure/12;
			tenure+=24;
			arr[i++]=interest;
			arr[i]=emi;
		}
		System.out.println(arr[0]);
		
		return arr;
	}
	
	
}
