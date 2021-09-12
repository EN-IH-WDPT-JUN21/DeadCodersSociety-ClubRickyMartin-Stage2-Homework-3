package DeadCodersSocietyClubRickyMartinStage2Homework3.repository;

import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Product;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Contact;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Opportunity;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {
    Optional<Opportunity> findFirstByProductAndQuantityAndDecisionMakerAndSalesRep(Product product, int quantity, Contact decisionMaker, SalesRep salesRep);

    @Query(value="SELECT r.name, count(o.opportunity_id) FROM opportunities o JOIN sales_reps r on o.sales_rep_id=r.sales_rep_id GROUP BY r.name", nativeQuery = true)
    List<String> reportOpportunityBySalesRep();

    @Query(value="SELECT r.name, count(o.opportunity_id) FROM opportunities o JOIN sales_reps r on o.sales_rep_id=r.sales_rep_id WHERE o.status='CLOSED_WON' GROUP BY r.name", nativeQuery = true)
    List<String> reportCLOSEDWONbySalesRep();

    @Query(value="SELECT r.name, count(o.opportunity_id) FROM opportunities o JOIN sales_reps r on o.sales_rep_id=r.sales_rep_id WHERE o.status='CLOSED_LOST' GROUP BY r.name", nativeQuery = true)
    List<String> reportCLOSEDLOSTbySalesRep();

    @Query(value="SELECT r.name, count(o.opportunity_id) FROM opportunities o JOIN sales_reps r on o.sales_rep_id=r.sales_rep_id WHERE o.status='OPEN' GROUP BY r.name", nativeQuery = true)
    List<String> reportOPENbySalesRep();

    @Query(value="SELECT product, count(opportunity_id) FROM opportunities GROUP BY product", nativeQuery = true)
    List<String> reportOpportunitybytheproduct();

    @Query(value="SELECT product, count(opportunity_id) FROM opportunities WHERE status='CLOSED_WON' GROUP BY product", nativeQuery = true)
    List<String> reportCLOSEDWONbytheproduct();

    @Query(value="SELECT product, count(opportunity_id) FROM opportunities WHERE status='CLOSED_LOST' GROUP BY product", nativeQuery = true)
    List<String> reportCLOSEDLOSTbytheproduct();

    @Query(value="SELECT product, count(opportunity_id) FROM opportunities WHERE status='OPEN' GROUP BY product", nativeQuery = true)
    List<String> reportOPENbytheproduct();

    @Query(value="SELECT a.country, count(o.opportunity_id) FROM opportunities o join accounts a on o.account_id=a.account_id GROUP BY a.country", nativeQuery = true)
    List<String> reportOpportunitybyCountry();

    @Query(value="SELECT a.country, count(o.opportunity_id) FROM opportunities o join accounts a on o.account_id=a.account_id WHERE o.status='CLOSED_WON' GROUP BY a.country", nativeQuery = true)
    List<String> reportCLOSEDWONbyCountry();

    @Query(value="SELECT a.country, count(o.opportunity_id) FROM opportunities o join accounts a on o.account_id=a.account_id WHERE o.status='CLOSED_LOST' GROUP BY a.country", nativeQuery = true)
    List<String> reportCLOSEDLOSTbyCountry();

    @Query(value="SELECT a.country, count(o.opportunity_id) FROM opportunities o join accounts a on o.account_id=a.account_id WHERE o.status='OPEN' GROUP BY a.country", nativeQuery = true)
    List<String> reportOPENbyCountry();

    @Query(value="SELECT a.city, count(o.opportunity_id) FROM opportunities o join accounts a on o.account_id=a.account_id GROUP BY a.city", nativeQuery = true)
    List<String> reportOpportunitybyCity();

    @Query(value="SELECT a.city, count(o.opportunity_id) FROM opportunities o join accounts a on o.account_id=a.account_id WHERE o.status='CLOSED_WON' GROUP BY a.city", nativeQuery = true)
    List<String> reportCLOSEDWONbyCity();

    @Query(value="SELECT a.city, count(o.opportunity_id) FROM opportunities o join accounts a on o.account_id=a.account_id WHERE o.status='CLOSED_LOST' GROUP BY a.city", nativeQuery = true)
    List<String> reportCLOSEDLOSTbyCity();

    @Query(value="SELECT a.city, count(o.opportunity_id) FROM opportunities o join accounts a on o.account_id=a.account_id WHERE o.status='OPEN' GROUP BY a.city", nativeQuery = true)
    List<String> reportOPENbyCity();

    @Query(value="SELECT a.industry, count(o.opportunity_id) FROM opportunities o join accounts a on o.account_id=a.account_id GROUP BY a.industry", nativeQuery = true)
    List<String> reportOpportunitybyIndustry();

    @Query(value="SELECT a.industry, count(o.opportunity_id) FROM opportunities o join accounts a on o.account_id=a.account_id WHERE o.status='CLOSED_WON' GROUP BY a.industry", nativeQuery = true)
    List<String> reportCLOSEDWONbyIndustry();

    @Query(value="SELECT a.industry, count(o.opportunity_id) FROM opportunities o join accounts a on o.account_id=a.account_id WHERE o.status='CLOSED_LOST' GROUP BY a.industry", nativeQuery = true)
    List<String> reportCLOSEDLOSTbyIndustry();

    @Query(value="SELECT a.industry, count(o.opportunity_id) FROM opportunities o join accounts a on o.account_id=a.account_id WHERE o.status='OPEN' GROUP BY a.industry", nativeQuery = true)
    List<String> reportOPENbyIndustry();

}
