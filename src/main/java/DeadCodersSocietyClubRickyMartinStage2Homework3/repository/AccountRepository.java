package DeadCodersSocietyClubRickyMartinStage2Homework3.repository;

import DeadCodersSocietyClubRickyMartinStage2Homework3.enums.Industry;
import DeadCodersSocietyClubRickyMartinStage2Homework3.dao.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findFirstByIndustryAndEmployeeCountAndCityAndCountry(Industry industry, int employeeCount, String city, String country);

    @Query(value="SELECT AVG(employee_count) FROM accounts", nativeQuery = true)
    List<String> meanEmployeeCount();

    @Query(value="SELECT AVG(1.0*employee_count) median FROM  (SELECT employee_count, ROW_NUMBER() OVER (ORDER BY employee_count) rn, COUNT(*) OVER () c FROM accounts) AS x WHERE rn IN ((c)/2, (c + 2)/2, (c+1)/2)", nativeQuery = true)
    List<String> medianEmployeeCount();

    @Query(value="SELECT MAX(employee_count) FROM accounts", nativeQuery = true)
    List<String> maxEmployeeCount();

    @Query(value="SELECT MIN(employee_count) FROM accounts", nativeQuery = true)
    List<String> minEmployeeCount();

    @Query(value="SELECT product, AVG(1.0*quantity) median FROM( SELECT product, quantity, ROW_NUMBER() OVER (PARTITION BY product ORDER BY quantity) rn, COUNT(*) OVER (PARTITION BY product) c FROM opportunities) AS x WHERE rn IN ((c)/2, (c + 2)/2, (c+1)/2) GROUP BY product", nativeQuery = true)
    List<String> medianQuantity();

    @Query(value="SELECT product, MAX(quantity) FROM accounts join opportunities on opportunities.account_id=accounts.account_id GROUP BY product", nativeQuery = true)
    List<String> maxQuantity();

    @Query(value="SELECT product, MIN(quantity) FROM accounts join opportunities on opportunities.account_id=accounts.account_id GROUP BY product", nativeQuery = true)
    List<String> minQuantity();

    @Query(value="SELECT product, AVG(quantity) FROM accounts join opportunities on opportunities.account_id=accounts.account_id GROUP BY product", nativeQuery = true)
    List<String> meanQuantity();

    @Query(value="SELECT AVG(1.0*opps) median FROM ( SELECT opps, ROW_NUMBER() OVER (ORDER BY opps) rn, COUNT(*) OVER () c FROM (SELECT account_id, count(*) opps from opportunities GROUP BY account_id) opportunities_agg) AS x WHERE rn IN ((c)/2, (c + 2)/2, (c+1)/2)", nativeQuery = true)
    List<String> medianOppsperAccount();

    @Query(value="SELECT AVG(o.opps) FROM (SELECT account_id, count(*) opps from opportunities GROUP BY account_id) o", nativeQuery = true)
    List<String> meanOppsperAccount();

    @Query(value="SELECT MAX(o.opps) FROM (SELECT account_id, count(*) opps from opportunities GROUP BY account_id) o", nativeQuery = true)
    List<String> maxOppsperAccount();

    @Query(value="SELECT MIN(o.opps) FROM (SELECT account_id, count(*) opps from opportunities GROUP BY account_id) o", nativeQuery = true)
    List<String> minOppsperAccount();
}
