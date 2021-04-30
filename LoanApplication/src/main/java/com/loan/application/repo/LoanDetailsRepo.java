package com.loan.application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.application.model.LoanDetails;

@Repository
public interface LoanDetailsRepo extends JpaRepository<LoanDetails, String> {

}
