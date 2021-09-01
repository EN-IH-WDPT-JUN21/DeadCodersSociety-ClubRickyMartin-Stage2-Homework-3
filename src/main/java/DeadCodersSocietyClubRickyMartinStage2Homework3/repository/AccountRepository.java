package DeadCodersSocietyClubRickyMartinStage2Homework3.repository;

import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
