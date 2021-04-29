package com.loan.application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.application.model.EligibilityParameters;

@Repository
public interface EligibilityParametersRepository extends JpaRepository<EligibilityParameters, String> {

}
