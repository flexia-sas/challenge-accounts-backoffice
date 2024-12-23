package ar.com.flexia.accounts_backoffice.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	List<Account> findAllByStatus(Account.Status status);
}
