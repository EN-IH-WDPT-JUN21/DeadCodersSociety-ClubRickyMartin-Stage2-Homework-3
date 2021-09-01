package DeadCodersSocietyClubRickyMartinStage2Homework3.repository;

import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
