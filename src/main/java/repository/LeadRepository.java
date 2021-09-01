package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dao.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead,Integer> {
}
