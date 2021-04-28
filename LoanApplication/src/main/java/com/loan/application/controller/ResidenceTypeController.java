package com.loan.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loan.application.log.GenerateLogs;
import com.loan.application.model.ResidenceType;
import com.loan.application.service.ResidenceTypeService;

@RestController
public class ResidenceTypeController {

	@Autowired
	ResidenceTypeService service;
	
	@RequestMapping(value = "/fetch-city", method = RequestMethod.GET)
	public ResponseEntity<List<ResidenceType>> fetchCity(){
		try {
		List<ResidenceType> list = service.findAll();
		
		return new ResponseEntity<List<ResidenceType>>(list, HttpStatus.OK);
		}catch(Exception ex)
		{
			GenerateLogs.writeLog(ex.getMessage());
			return new ResponseEntity<List<ResidenceType>>(new ArrayList<ResidenceType>(), HttpStatus.OK);
		}
		
	}
}
