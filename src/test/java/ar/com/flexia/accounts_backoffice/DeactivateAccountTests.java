package ar.com.flexia.accounts_backoffice;

import ar.com.flexia.accounts_backoffice.api.AccountsController;
import ar.com.flexia.accounts_backoffice.api.dto.NewAccount;
import ar.com.flexia.accounts_backoffice.domain.Account;
import ar.com.flexia.accounts_backoffice.domain.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeactivateAccountTests {
	@Autowired
	private AccountsController controller;
	@Autowired
	private AccountRepository repository;

	private Account originalAccount;

	@BeforeEach
	void setup() {
		this.originalAccount = repository.save(new Account("test", "test@test.com", "pass1"));
	}

	@Test
	void ok() {
		controller.deactivateAccount(originalAccount.getId());
		var updatedAccount = repository.findById(originalAccount.getId()).orElseThrow();
		Assertions.assertFalse(updatedAccount.isActive());
		Assertions.assertNotNull(updatedAccount.getLastUpdated());
	}

}
