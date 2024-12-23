package ar.com.flexia.accounts_backoffice;

import ar.com.flexia.accounts_backoffice.api.AccountsController;
import ar.com.flexia.accounts_backoffice.api.dto.NewAccount;
import ar.com.flexia.accounts_backoffice.api.dto.PasswordChange;
import ar.com.flexia.accounts_backoffice.domain.Account;
import ar.com.flexia.accounts_backoffice.domain.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChangePasswordTests {
	@Autowired
	private AccountsController controller;
	@Autowired
	private AccountRepository repository;
	private long id;

	@BeforeEach
	void setup() {
		var account = repository.save(new Account("test", "test@test.com", "pass1"));
		this.id = account.getId();
	}

	@Test
	void ok() {
		controller.changeAccountPassword(id, new PasswordChange("pass1", "pass2"));
		var account = repository.findById(id).orElseThrow();
		Assertions.assertEquals("pass2", account.getPassword());
	}
}
