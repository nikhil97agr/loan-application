package com.loan.application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loan.application.model.ResidenceType;

@Repository
public interface ResidenceTypeRepository extends JpaRepository<ResidenceType, String> {

}
