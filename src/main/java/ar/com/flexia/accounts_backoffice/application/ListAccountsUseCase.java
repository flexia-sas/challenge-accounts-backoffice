package ar.com.flexia.accounts_backoffice.application;

import ar.com.flexia.accounts_backoffice.domain.Account;
import ar.com.flexia.accounts_backoffice.domain.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Use case for listing accounts
 */
@Service
public class ListAccountsUseCase {
	private final AccountRepository accountRepository;

	public ListAccountsUseCase(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public List<Account> listActiveAccounts() {
		return accountRepository.findAll();
	}

	public List<Account> listInactiveAccounts() {
		return accountRepository.findAll();
	}
}
