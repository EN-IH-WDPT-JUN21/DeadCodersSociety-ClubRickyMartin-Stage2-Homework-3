package com.ironhack.homework3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ironhack.homework3.dao.Opportunity;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity,Integer> {
}