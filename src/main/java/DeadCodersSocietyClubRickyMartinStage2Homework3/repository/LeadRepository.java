package DeadCodersSocietyClubRickyMartinStage2Homework3.repository;

import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Lead;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {
    Optional<Lead> findFirstByNameAndPhoneNumberAndEmailAndCompanyNameAndSalesRep(String name, String phoneNumber, String email, String companyName, SalesRep salesRep);

    @Query(value="SELECT r.name, count(l.lead_id) FROM leads l JOIN sales_reps r on l.sales_rep_id=r.sales_rep_id GROUP BY r.name", nativeQuery = true)
    List<String> reportLeadBySalesRep();

}
