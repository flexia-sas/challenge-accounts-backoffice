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

import java.util.List;

@SpringBootTest
class ListAccountsTest {
	@Autowired
	private AccountsController controller;
	@Autowired
	private AccountRepository repository;

	@BeforeEach
	void setup() {
		repository.deleteAll();
		var ac1 = new Account("1", "1@test.com", "pass1");
		var ac2 = new Account("2", "2@test.com", "pass2");
		var ac3 = new Account("3", "3@test.com", "pass3");
		ac2.deactivate();
		repository.saveAll(List.of(ac1, ac2, ac3));
	}

	@Test
	void listActive() {
		var active = controller.listAccounts(false);
		Assertions.assertEquals(2, active.size());
	}

	@Test
	void listInactive() {
		var inactive = controller.listAccounts(true);
		Assertions.assertEquals(1, inactive.size());
	}
}
