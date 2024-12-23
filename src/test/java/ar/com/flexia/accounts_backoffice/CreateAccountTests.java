package ar.com.flexia.accounts_backoffice;

import ar.com.flexia.accounts_backoffice.api.AccountsController;
import ar.com.flexia.accounts_backoffice.api.dto.NewAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreateAccountTests {
	@Autowired
	private AccountsController controller;

	@Test
	void ok() {
		var id = controller.createAccount(
				new NewAccount("Lucas", "lucas.test@test.com", "pass1"));
		Assertions.assertNotNull(id);
	}
}
