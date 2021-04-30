package com.loan.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.application.model.EligibilityParameters;
import com.loan.application.model.OfferDetails;

@Service
public class OffersService {
	
	@Autowired
	PersonalInfoService personalService;


	public List<OfferDetails> loanOffers(EligibilityParameters eligibilityParam) {
		// TODO Auto-generated method stub
		double arr[]=new double[9];
		double amt = eligibilityParam.getLoanAmt();
		double rate = 11/1200f;
		double tenure = eligibilityParam.getMinTenure();
		
		tenure=tenure*12;
		
		double emi;
		List<OfferDetails> offers = new ArrayList<OfferDetails>();
		System.out.println();
		for(int i=0;i<3;i++)
		{
			emi=(amt*rate*Math.pow((1+rate), tenure))/(Math.pow((1+rate), tenure)-1);
			System.out.println(emi);
			
			double interest = (emi*tenure)-amt;
			OfferDetails offer = new OfferDetails();
//			arr[i++]=tenure/12;
			offer.setTenure(tenure/12);
			tenure+=24;
//			arr[i++]=interest;
			offer.setInterest(interest);
//			arr[i]=emi;
			offer.setEmi(emi);
			
			offers.add(offer);
		}
		
		return offers;
	}
	
	
}
