package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dao.Opportunity;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity,Integer> {
}
