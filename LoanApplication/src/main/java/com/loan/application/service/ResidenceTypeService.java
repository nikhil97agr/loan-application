package com.loan.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loan.application.log.GenerateLogs;
import com.loan.application.model.ResidenceType;
import com.loan.application.repo.ResidenceTypeRepository;

@Service
public class ResidenceTypeService {
	
	@Autowired
	ResidenceTypeRepository repository;
	
	public List<ResidenceType> findAll(){
		try {
		return repository.findAll();
		}catch(Exception ex)
		{
			GenerateLogs.writeLog(ex.getMessage());
			return new ArrayList<ResidenceType>();
		}
	}

}
