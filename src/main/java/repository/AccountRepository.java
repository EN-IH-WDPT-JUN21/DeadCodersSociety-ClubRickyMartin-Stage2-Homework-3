package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dao.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
