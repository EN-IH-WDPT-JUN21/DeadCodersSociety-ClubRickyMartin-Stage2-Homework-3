package DeadCodersSocietyClubRickyMartinStage2Homework3.repository;

import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Integer> {
}
