package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dao.SalesRep;

@Repository
public interface salesRepRepository extends JpaRepository<SalesRep,Integer> {
}
