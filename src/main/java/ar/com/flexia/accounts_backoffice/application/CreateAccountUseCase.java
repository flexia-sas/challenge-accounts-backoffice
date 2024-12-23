package ar.com.flexia.accounts_backoffice.application;

import ar.com.flexia.accounts_backoffice.domain.Account;
import ar.com.flexia.accounts_backoffice.domain.AccountRepository;
import org.springframework.stereotype.Service;

/**
 * Use case for creating a new account
 */
@Service
public class CreateAccountUseCase {
	private final AccountRepository accountRepository;

	public CreateAccountUseCase(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public Account createAccount(String name, String email, String password) {
		var account = new Account(name, email, password);
		return accountRepository.save(account);
	}
}
