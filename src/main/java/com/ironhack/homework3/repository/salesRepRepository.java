package com.ironhack.homework3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ironhack.homework3.dao.SalesRep;

@Repository
public interface salesRepRepository extends JpaRepository<SalesRep,Integer> {
}
