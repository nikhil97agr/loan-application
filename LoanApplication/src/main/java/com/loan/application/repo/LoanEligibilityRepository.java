package com.loan.application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.application.model.LoanEligibilityParam;

@Repository
public interface LoanEligibilityRepository extends JpaRepository<LoanEligibilityParam, String> {
	
}
