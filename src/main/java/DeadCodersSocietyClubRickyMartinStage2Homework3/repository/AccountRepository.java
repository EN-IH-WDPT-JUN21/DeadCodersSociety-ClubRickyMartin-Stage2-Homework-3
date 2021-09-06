package DeadCodersSocietyClubRickyMartinStage2Homework3.repository;

import DeadCodersSocietyClubRickyMartinStage2Homework3.Industry;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Account;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Contact;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findFirstByIndustryAndEmployeeCountAndCityAndCountry(Industry industry, int employeeCount, String city, String country);

    @Query(value="SELECT AVG(dd.employee_count) as median_val FROM (SELECT d.employee_count, :rownum=:rownum+1 as `row_number`, :total_rows=:rownum FROM accounts d, (SELECT :rownum=0) r WHERE d.employee_count is NOT NULL ORDER BY d.employee_count) as dd WHERE dd.row_number IN ( FLOOR((:total_rows+1)/2), FLOOR((:total_rows+2)/2) )", nativeQuery = true)
    List<String> meanEmployeeCount();


//    MeanEmployeeCount
//            MedianEmployeeCount
//    MaxEmployeeCount
//            MinEmployeeCount
//    MeanQuantity
//            MedianQuantity
//    MaxQuantity
//            MinQuantity
//    MeanOppsperAccount
//            MedianOppsperAccount
//    MaxOppsperAccount
//            MinOppsperAccount

}
